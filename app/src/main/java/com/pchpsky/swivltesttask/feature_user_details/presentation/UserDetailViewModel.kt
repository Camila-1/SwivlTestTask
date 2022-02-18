package com.pchpsky.swivltesttask.feature_user_details.presentation

import com.pchpsky.swivltesttask.feature_user_details.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface UserDetailViewModel {
    val user: StateFlow<User>
    suspend fun getUserDetail(userName: String)
}