package ru.justneedcoffee.zennotes.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.androidx.compose.koinViewModel
import ru.justneedcoffee.zennotes.NotesRepository
import ru.justneedcoffee.zennotes.ui.Routes
import ru.justneedcoffee.zennotes.ui.viewmodels.NoteEditingViewModel
import ru.justneedcoffee.zennotes.ui.viewmodels.NotesViewModel

enum class Screen {
    Start,
    EmptyNotes,
}

enum class NotesLoadState {
    Loading,
    Success,
    Error
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    var currentScreen by remember { mutableStateOf(Screen.Start) }


    var notesLoadState by remember { mutableStateOf(NotesLoadState.Loading) }

    // заметки
    var notes by remember { mutableStateOf(NotesRepository.getAll()) }

    // счётчик попыток, чтобы перезапускать загрузку по кнопке "Повторить"
    var notesLoadAttempt by remember { mutableIntStateOf(0) }

    // id заметки, которую редактируем
    var editingNoteId: Long by remember { mutableStateOf<Long>(-1) }

    LaunchedEffect(currentScreen, notesLoadAttempt) {
        if (currentScreen == Screen.EmptyNotes) {
            notesLoadState = NotesLoadState.Loading

            // задержка 2 секунды
            kotlinx.coroutines.delay(2000)

            try {
                // тут можно эмулировать ошибку, если нужно показать экран ошибки:
                val shouldFail = false // эмулируем ошибку

                if (shouldFail) error("Network error")

                notes = NotesRepository.getAll()
                notesLoadState = NotesLoadState.Success
            } catch (_: Exception) {
                notesLoadState = NotesLoadState.Error
            }
        }
    }


    NavHost(navController = navController, startDestination = Routes.Start.route) {
        composable(Routes.Start.route) {
            StartScreen(
                onLoginClick = { navController.navigate(Routes.Login.route) },
                onSignUpClick = { navController.navigate(Routes.Registration.route) },
                onContinueWithoutAccountClick = {
                    navController.navigate(Routes.ContinueWithoutAccount.route)
                }
            )
        }

        composable(Routes.ContinueWithoutAccount.route) {
            ContinueWithoutAccountScreen(
                onBackClick = { navController.popBackStack() },
                onContinueClick = { currentScreen = Screen.EmptyNotes
                    navController.navigate(Routes.Notes.route) }
            )
        }

        composable(Routes.Registration.route) {
            RegistrationScreen(
                onBackClick = { navController.popBackStack() },
                onRegisterClick = { currentScreen = Screen.EmptyNotes
                    navController.navigate(Routes.Notes.route) },
                onLoginClick = { navController.navigate(Routes.Login.route) }
            )
        }

        composable(Routes.Login.route) {
            LoginScreen(
                onBackClick = { navController.popBackStack() },
                onLoginClick = { currentScreen = Screen.EmptyNotes
                    navController.navigate(Routes.Notes.route) },
                onRegisterClick = { navController.navigate(Routes.Registration.route) },
                onForgotPasswordClick = { navController.navigate(Routes.ForgotPasswordEmail.route) }
            )
        }

        composable(Routes.ForgotPasswordEmail.route) {
            ForgotPasswordEmailScreen(
                onBackClick = { navController.popBackStack() },
                onSendCodeClick = { navController.navigate(Routes.ConfirmEmail.route) }
            )
        }

        composable(Routes.ConfirmEmail.route) {
            ConfirmEmailScreen(
                onBackClick = { navController.popBackStack() },
                onContinueClick = { navController.navigate(Routes.NewPassword.route) },
                onResendClick = { }
            )
        }

        composable(Routes.NewPassword.route) {
            NewPasswordScreen(
                onBackClick = { navController.popBackStack() },
                onConfirmClick = { navController.navigate(Routes.Login.route) }
            )
        }

        composable(Routes.Notes.route) {
            when (notesLoadState) {
                NotesLoadState.Loading -> NotesLoadingScreen()

                NotesLoadState.Error -> ErrorScreen(
                    message = "Не удалось загрузить заметки.\nПроверьте подключение к интернету.",
                    onRetryClick = {
                        // увеличиваем счётчик — LaunchedEffect перезапустится
                        notesLoadAttempt++
                    }
                )

                NotesLoadState.Success -> NotesScreen(
                    notes = notes,
                    onCreateNoteClick = {
                        val note = NotesRepository.createEmpty()
                        editingNoteId = note.id
                        notes = NotesRepository.getAll()
                        navController.navigate(Routes.NoteEditing.route)

                    },
                    onNoteClick = { id ->
                        editingNoteId = id
                        navController.navigate(Routes.NoteEditing.route)
                    }
                )
            }
        }

        composable(Routes.NoteEditing.route)
//                + "/{id}",
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
         {
            val id = editingNoteId
            val note = id.let { NotesRepository.getById(it) }

            if (note == null) {
                currentScreen = Screen.EmptyNotes
                navController.navigate(Routes.Notes.route)
            } else {
                var title by remember(note.id) { mutableStateOf(note.title) }
                var text by remember(note.id) { mutableStateOf(note.text) }

                NoteEditingScreen(
                    title = title,
                    text = text,
                    onTitleChange = { newTitle ->
                        title = newTitle
                        NotesRepository.updateTitle(note.id, newTitle)
                        notes = NotesRepository.getAll().toList()
                    },
                    onTextChange = { newText ->
                        text = newText
                        NotesRepository.updateText(note.id, newText)
                        notes = NotesRepository.getAll().toList()
                    },
                    onBackClick = {
                        NotesRepository.deleteIfEmpty(note.id)
                        notes = NotesRepository.getAll().toList()
                        navController.popBackStack()
                    },
                    onShareClick = { /* TODO */ }
                )
            }
        }
    }
}