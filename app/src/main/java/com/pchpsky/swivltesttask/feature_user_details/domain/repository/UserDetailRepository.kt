package com.pchpsky.swivltesttask.feature_user_details.domain.repository

import com.pchpsky.swivltesttask.feature_user_details.domain.model.User

interface UserDetailRepository {
    suspend fun getUserDetail(userName: String): User
}