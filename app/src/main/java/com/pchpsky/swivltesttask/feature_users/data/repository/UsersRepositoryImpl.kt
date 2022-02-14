package com.pchpsky.swivltesttask.feature_users.data.repository

import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.UsersNetworkClient
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository

class UsersRepositoryImpl(private val networkClient: UsersNetworkClient) : UsersRepository {

    override suspend fun gerUsers(): List<User> {
        return networkClient.users()
    }
}