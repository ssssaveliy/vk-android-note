package ru.justneedcoffee.domain.usecases.note

import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repository.NoteRepository

class GetNotesUseCase(private val noteRepository: NoteRepository) {
    suspend fun execute(): List<NoteModel> {
        return noteRepository.getNotes()
    }
}