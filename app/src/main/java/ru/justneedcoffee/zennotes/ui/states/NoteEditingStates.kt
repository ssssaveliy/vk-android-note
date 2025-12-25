package ru.justneedcoffee.zennotes.ui.states

import ru.justneedcoffee.domain.models.NoteModel


sealed class NoteEditingStates {
    data class MainState(val data: NoteModel) : NoteEditingStates()
}

sealed class NoteEditingEvents {
    data object AddNote : NoteEditingEvents()
    data object RemoveNote : NoteEditingEvents()
    data object GetNote : NoteEditingEvents()
}