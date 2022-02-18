package com.pchpsky.swivltesttask.feature_user_details.domain.repository

import com.pchpsky.swivltesttask.core.domain.model.User

interface UserDetailRepository {
    suspend fun getUserDetail()
}