package com.pchpsky.swivltesttask.feature_users.presentation

import androidx.paging.PagingData
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import kotlinx.coroutines.flow.Flow

interface UsersViewModel {
    val users: Flow<PagingData<UserListItem>>
    fun onEvent(event: UsersEvent)
}