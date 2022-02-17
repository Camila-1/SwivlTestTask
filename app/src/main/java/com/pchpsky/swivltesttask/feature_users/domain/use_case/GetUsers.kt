package com.pchpsky.swivltesttask.feature_users.domain.use_case

import androidx.paging.PagingData
import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsers(private val repository: UsersRepository) {

    suspend operator fun invoke(): Flow<PagingData<User>> {
        val pagingDataFlow = repository.gerUsers()
        return pagingDataFlow
    }
}