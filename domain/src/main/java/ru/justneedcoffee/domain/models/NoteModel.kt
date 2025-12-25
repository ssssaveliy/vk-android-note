package ru.justneedcoffee.domain.models

data class NoteModel(
    val id: Int,
    var title: String,
    var text: String,
    val createdAt: Int
)