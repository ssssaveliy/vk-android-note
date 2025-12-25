package ru.justneedcoffee.domain.usecases.user

import ru.justneedcoffee.domain.models.UserModel
import ru.justneedcoffee.domain.repositories.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(): UserModel {
        return userRepository.getUser()
    }
}