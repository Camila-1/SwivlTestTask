package com.pchpsky.swivltesttask.feature_users.domain.repository

import androidx.paging.PagingData
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun gerUsers() : Flow<PagingData<UserListItem>>
}