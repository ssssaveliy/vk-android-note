package ru.justneedcoffee.domain.repository

import ru.justneedcoffee.domain.models.NoteModel

interface NoteRepository {
    suspend fun getNotes(): List<NoteModel>
//    suspend fun getNote(id: Int): NoteModel
    suspend fun addNote(note: NoteModel)
    suspend fun removeNote(note: NoteModel)
    suspend fun editNote(note: NoteModel)
}