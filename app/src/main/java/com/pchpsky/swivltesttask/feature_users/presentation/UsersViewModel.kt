package com.pchpsky.swivltesttask.feature_users.presentation

import androidx.paging.PagingData
import com.pchpsky.swivltesttask.core.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface UsersViewModel {
    val users: Flow<PagingData<User>>
    fun onEvent(event: UsersEvent)
}