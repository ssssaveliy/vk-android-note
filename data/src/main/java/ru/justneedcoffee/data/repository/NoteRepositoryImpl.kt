package ru.justneedcoffee.data.repository

import ru.justneedcoffee.data.db.NotesDao
import ru.justneedcoffee.data.noteEntityToModel
import ru.justneedcoffee.data.noteModelToEntity
import ru.justneedcoffee.domain.models.NoteModel
import ru.justneedcoffee.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val dao: NotesDao
) : NoteRepository {
    override suspend fun getNotes(): List<NoteModel> {
        return dao.getNotes().map { noteEntityToModel(it) }
    }

//    override suspend fun getNote(id: Int): NoteModel {
//        return noteEntityToModel(dao.getNote(id))
//    }

    override suspend fun addNote(note: NoteModel) {
        dao.addNote(noteModelToEntity(note))
    }

    override suspend fun removeNote(note: NoteModel) {
        dao.removeNote(noteModelToEntity(note))
    }

    override suspend fun editNote(note: NoteModel) {
        dao.addNote(noteModelToEntity(note))
    }
}