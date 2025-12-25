package ru.justneedcoffee.domain.usecases.note

import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repository.NoteRepository

class DeleteIfEmptyUseCase(private val noteRepository: NoteRepository, private val note: NoteModel) {
    suspend fun execute() {
        if (note.title.isEmpty() && note.text.isEmpty()) {
            noteRepository.removeNote(note)
        }
    }
}