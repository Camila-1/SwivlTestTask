package com.pchpsky.swivltesttask.feature_user_details.presentation

import androidx.lifecycle.ViewModel
import com.pchpsky.swivltesttask.feature_user_details.domain.model.User
import com.pchpsky.swivltesttask.feature_user_details.domain.use_case.UserDetailUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserDetailViewModelIml(private val userDetailUseCases: UserDetailUseCases) : ViewModel(), UserDetailViewModel {

    private val _user = MutableStateFlow(User())
    override val user: StateFlow<User> = _user

    override suspend fun getUserDetail(userName: String) {
        val user = userDetailUseCases.getUser(userName)
        _user.value = user
    }
}