package ru.justneedcoffee.domain.usecases.note

import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repositories.NoteRepository

class LoadNotesUseCase(private val noteRepository: NoteRepository, private val userId: Int) {
    suspend fun execute(): List<NoteModel> {
        return noteRepository.loadNotes(userId)
    }
}