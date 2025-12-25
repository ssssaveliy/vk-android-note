package ru.justneedcoffee.domain.models

data class NoteModel(
    val id: Int,
    val title: String,
    val text: String,
    val userId: Int
)