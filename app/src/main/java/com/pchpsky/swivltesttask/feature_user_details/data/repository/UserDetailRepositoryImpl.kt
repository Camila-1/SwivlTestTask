package com.pchpsky.swivltesttask.feature_user_details.data.repository

import com.pchpsky.swivltesttask.feature_user_details.data.data_source.network.UserDetailNetworkClient
import com.pchpsky.swivltesttask.feature_user_details.domain.model.User
import com.pchpsky.swivltesttask.feature_user_details.domain.repository.UserDetailRepository

class UserDetailRepositoryImpl(private val networkClient: UserDetailNetworkClient)
    : UserDetailRepository {
    override suspend fun getUserDetail(userName: String): User {
        return networkClient.getUser(userName)
    }

}