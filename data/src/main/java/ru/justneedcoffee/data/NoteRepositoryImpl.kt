package ru.justneedcoffee.data

import kotlinx.coroutines.delay
import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repositories.NoteRepository

class NoteRepositoryImpl : NoteRepository {
    private val notes: MutableList<NoteModel> = mutableListOf(
        NoteModel(
            1,
            "Какая-то заметка",
            "Какой-то текст в какой-то заметке",
            1
        ),
        NoteModel(
            2,
            "Важная заметка",
            "Очень важный текст в важной заметке",
            1
        )
    )

    override suspend fun loadNotes(userId: Int): List<NoteModel> {
        delay(1500)
        return notes.filter { it.userId == userId }
    }

    override fun addNote(note: NoteModel) {
        notes.add(note)
    }

    override fun deleteNote(note: NoteModel) {
        notes.remove(note)
    }
}