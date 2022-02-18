package com.pchpsky.swivltesttask.feature_users.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.UsersNetworkClient
import com.pchpsky.swivltesttask.feature_users.data.data_source.paging.UsersPagingSource
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class UsersRepositoryImpl(private val networkClient: UsersNetworkClient) : UsersRepository {

    override suspend fun gerUsers(): Flow<PagingData<UserListItem>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { UsersPagingSource(networkClient) }
        ).flow
    }
}