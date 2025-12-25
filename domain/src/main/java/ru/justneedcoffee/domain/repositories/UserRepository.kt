package ru.justneedcoffee.domain.repositories

import ru.justneedcoffee.domain.models.UserModel

interface UserRepository {
    suspend fun getUser(): UserModel
}