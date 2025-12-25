package ru.justneedcoffee.domain.repositories

import ru.justneedcoffee.domain.models.NoteModel

interface NoteRepository {
    suspend fun loadNotes(userId: Int): List<NoteModel>
    fun addNote(note: NoteModel)
    fun deleteNote(note: NoteModel)
}