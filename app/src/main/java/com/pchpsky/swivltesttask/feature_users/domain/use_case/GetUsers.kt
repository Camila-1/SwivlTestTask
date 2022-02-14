package com.pchpsky.swivltesttask.feature_users.domain.use_case

import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository

class GetUsers(private val repository: UsersRepository) {

    suspend operator fun invoke(): List<User> {
        return repository.gerUsers()
    }
}