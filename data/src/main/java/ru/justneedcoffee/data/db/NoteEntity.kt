package ru.justneedcoffee.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(defaultValue = "") var title: String,
    @ColumnInfo(defaultValue = "") var text: String,
    val createdAt: Int
)