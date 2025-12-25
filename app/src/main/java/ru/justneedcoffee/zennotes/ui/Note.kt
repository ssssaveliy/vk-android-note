package ru.justneedcoffee.zennotes.ui

data class Note(
    val id: Long,
    var title: String,
    var text: String,
    val createdAt: Long
)