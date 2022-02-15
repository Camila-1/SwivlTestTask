package com.pchpsky.swivltesttask.feature_users.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.UsersNetworkClient
import com.pchpsky.swivltesttask.feature_users.data.data_source.paging.UsersPagingSource
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsersRepositoryImpl(private val pagingSource: UsersPagingSource) : UsersRepository {

    override suspend fun gerUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { pagingSource }
        ).flow
    }
}