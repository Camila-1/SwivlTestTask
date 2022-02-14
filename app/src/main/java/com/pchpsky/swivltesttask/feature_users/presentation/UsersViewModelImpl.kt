package com.pchpsky.swivltesttask.feature_users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.domain.use_case.UsersUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModelImpl(private val usersUseCases: UsersUseCases) : ViewModel(), UsersViewModel {
    private val _users = MutableStateFlow(emptyList<User>())
    override val users: StateFlow<List<User>> = _users
    init {
        getUsers()
    }



    override fun onEvent(event: UsersEvent) {
        when(event) {
            is UsersEvent.Update -> {}
            is UsersEvent.LoadNew -> {}
        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            _users.value = usersUseCases.getUsers()
        }
    }
}