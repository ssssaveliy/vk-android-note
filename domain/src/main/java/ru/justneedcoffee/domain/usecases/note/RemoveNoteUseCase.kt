package ru.justneedcoffee.domain.usecases.note

import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repository.NoteRepository

class RemoveNoteUseCase (private val noteRepository: NoteRepository, private val note: NoteModel) {
    suspend fun execute() {
        return noteRepository.removeNote(note)
    }
}