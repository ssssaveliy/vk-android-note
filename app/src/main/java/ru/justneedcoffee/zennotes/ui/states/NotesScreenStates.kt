package ru.justneedcoffee.zennotes.ui.states

import ru.justneedcoffee.domain.models.NoteModel

sealed class NotesScreenStates {
    data object IdleState : NotesScreenStates()
    data object LoadingState : NotesScreenStates()
    data class ErrorState(val message: String) : NotesScreenStates()
    data class MainState(val data: List<NoteModel>) : NotesScreenStates()
}

sealed class NotesScreenEvents {
    data object GetNotes : NotesScreenEvents()
}