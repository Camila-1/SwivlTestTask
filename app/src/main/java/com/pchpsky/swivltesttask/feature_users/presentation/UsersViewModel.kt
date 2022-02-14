package com.pchpsky.swivltesttask.feature_users.presentation

import com.pchpsky.swivltesttask.core.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface UsersViewModel {
    val users: StateFlow<List<User>>
    fun onEvent(event: UsersEvent)
}