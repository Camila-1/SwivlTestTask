package com.pchpsky.swivltesttask.feature_users.domain.repository

import com.pchpsky.swivltesttask.core.domain.model.User

interface UsersRepository {

    suspend fun gerUsers() : List<User>
}