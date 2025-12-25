package ru.justneedcoffee.zennotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import ru.justneedcoffee.zennotes.ui.theme.ZenNotesTheme

private enum class Screen {
    Start,
    ContinueWithoutAccount,
    Registration,
    Login
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ZenNotesTheme {
                AppRoot()
            }
        }
    }
}

@Composable
private fun AppRoot() {
    var currentScreen by remember { mutableStateOf(Screen.Start) }

    when (currentScreen) {
        Screen.Start -> StartScreen(
            onLoginClick = { currentScreen = Screen.Login },
            onSignUpClick = { currentScreen = Screen.Registration },
            onContinueWithoutAccountClick = {
                currentScreen = Screen.ContinueWithoutAccount
            }
        )

        Screen.ContinueWithoutAccount -> ContinueWithoutAccountScreen(
            onBackClick = { currentScreen = Screen.Start },
            onContinueClick = { /* TODO */ }
        )

        Screen.Registration -> RegistrationScreen(
            onBackClick = { currentScreen = Screen.Start },
            onRegisterClick = { /* TODO: после регистрации */ },
            onLoginClick = { currentScreen = Screen.Login }
        )

        Screen.Login -> {
            // пока заглушка — позже экран "Вход"
            RegistrationScreen(
                onBackClick = { currentScreen = Screen.Start },
                onRegisterClick = { },
                onLoginClick = { }
            )
        }
    }
}