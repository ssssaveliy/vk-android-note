package ru.justneedcoffee.zennotes.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.justneedcoffee.domain.repository.NoteRepository
import ru.justneedcoffee.data.repository.NoteRepositoryImpl
import ru.justneedcoffee.zennotes.ui.viewmodels.NoteEditingViewModel
import ru.justneedcoffee.zennotes.ui.viewmodels.NotesViewModel

val appModule = module {
    viewModel<NotesViewModel>{ NotesViewModel(get()) }
    viewModel<NoteEditingViewModel>{ NoteEditingViewModel(get(), get(), get()) }
}

val domainModule = module {

}

val dataModule = module {
    single<NoteRepository>{ NoteRepositoryImpl(get()) }
}