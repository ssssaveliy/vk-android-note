package ru.justneedcoffee.data

import ru.justneedcoffee.data.db.NoteEntity
import ru.justneedcoffee.domain.models.NoteModel

fun noteModelToEntity(model: NoteModel): NoteEntity {
    return NoteEntity(
        id = model.id,
        title = model.title,
        text = model.text,
        createdAt = model.createdAt
    )
}

fun noteEntityToModel(entity: NoteEntity): NoteModel {
    return NoteModel(
        id = entity.id,
        title = entity.title,
        text = entity.text,
        createdAt = entity.createdAt
    )
}