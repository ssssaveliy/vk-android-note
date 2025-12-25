package ru.justneedcoffee.domain.repository

import ru.justneedcoffee.domain.models.UserModel

interface UserRepository {
    suspend fun getUser(): UserModel
}