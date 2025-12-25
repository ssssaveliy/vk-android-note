package ru.justneedcoffee.zennotes.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.justneedcoffee.domain.usecases.note.AddNoteUseCase
import ru.justneedcoffee.domain.usecases.note.DeleteIfEmptyUseCase
//import ru.justneedcoffee.domain.usecases.note.GetNoteUseCase
import ru.justneedcoffee.domain.usecases.note.RemoveNoteUseCase
import ru.justneedcoffee.zennotes.ui.states.NoteEditingStates
import ru.justneedcoffee.zennotes.ui.states.NotesScreenEvents

class NoteEditingViewModel(
    private val addNoteUseCase: AddNoteUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase,
    private val deleteIfEmptyUseCase: DeleteIfEmptyUseCase,
) : ViewModel() {
//    private val _state = MutableStateFlow<NoteEditingStates>(NoteEditingStates.MainState)
//    val state: StateFlow<NoteEditingStates>
//        get() = _state
//
//
//    fun obtainEvent(event: NotesScreenEvents, noteId: Int) {
//        when (event) {
//            NotesScreenEvents.GetNotes -> getNote(noteId)
//        }
//    }
//
//    fun getNote(noteId: Int) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val result = getNoteUseCase.execute()
//                _state.value = NoteEditingStates.MainState(result)
//            }
//        }
//
//    }
}