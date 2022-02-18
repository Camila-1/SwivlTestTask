package com.pchpsky.swivltesttask.feature_users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import com.pchpsky.swivltesttask.feature_users.domain.use_case.UsersUseCases
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UsersViewModelImpl(private val usersUseCases: UsersUseCases) : ViewModel(), UsersViewModel {
    private val _users: MutableStateFlow<PagingData<UserListItem>> = MutableStateFlow(PagingData.empty())
    override val users: Flow<PagingData<UserListItem>> = _users
    init {
        getUsers()
    }

    override fun onEvent(event: UsersEvent) {
        when(event) {
            is UsersEvent.Refresh -> { getUsers() }
            is UsersEvent.LoadNew -> {}
        }
    }

    private fun getUsers() {
        _users.value = PagingData.empty()
        viewModelScope.launch {
            usersUseCases.getUsers().cachedIn(viewModelScope).collect {
                _users.value = it
            }
        }
    }
}