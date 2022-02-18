package com.pchpsky.swivltesttask.feature_user_details.domain.use_case

import com.pchpsky.swivltesttask.feature_user_details.domain.model.User
import com.pchpsky.swivltesttask.feature_user_details.domain.repository.UserDetailRepository

class GetUser(private val repository: UserDetailRepository) {

    suspend operator fun invoke(userName: String): User {
        return repository.getUserDetail(userName)
    }
}
