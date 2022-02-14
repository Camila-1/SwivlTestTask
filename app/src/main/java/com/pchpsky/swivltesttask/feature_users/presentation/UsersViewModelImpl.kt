package com.pchpsky.swivltesttask.feature_users.presentation

import androidx.lifecycle.ViewModel
import com.pchpsky.swivltesttask.feature_users.domain.use_case.UsersUseCases

class UsersViewModelImpl(private val usersUseCases: UsersUseCases) : ViewModel(), UsersViewModel {

    override fun onEvent(event: UsersEvent) {
        when(event) {
            is UsersEvent.Update -> {}
            is UsersEvent.LoadNew -> {}
        }
    }
}