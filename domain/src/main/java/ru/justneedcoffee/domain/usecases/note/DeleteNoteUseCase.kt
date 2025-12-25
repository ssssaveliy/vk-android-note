package ru.justneedcoffee.domain.usecases.note

import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repositories.NoteRepository

class DeleteNoteUseCase (private val noteRepository: NoteRepository, private val note: NoteModel) {
    suspend fun execute() {
        return noteRepository.deleteNote(note)
    }
}