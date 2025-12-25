package ru.justneedcoffee.zennotes.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.justneedcoffee.domain.usecases.note.GetNotesUseCase
import ru.justneedcoffee.zennotes.ui.states.NotesScreenEvents
import ru.justneedcoffee.zennotes.ui.states.NotesScreenStates

class NotesViewModel(
    private val getNotesUseCase: GetNotesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow<NotesScreenStates>(NotesScreenStates.IdleState)
    val state: StateFlow<NotesScreenStates>
        get() = _state

    fun obtainEvent(event: NotesScreenEvents) {
        when (event) {
            NotesScreenEvents.GetNotes -> getNotes()
        }
    }

    private fun getNotes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = NotesScreenStates.LoadingState
                val result = getNotesUseCase.execute()
                _state.value = NotesScreenStates.MainState(result)
            }
        }
    }
}