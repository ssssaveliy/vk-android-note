package ru.justneedcoffee.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<NoteEntity>

    //@Query("SELECT 1 FROM notes WHERE notes.id = :noteId")
    //suspend fun getNote(noteId: Int): NoteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteEntity)

    @Delete
    suspend fun removeNote(note: NoteEntity)
}