package com.pchpsky.swivltesttask.feature_users.presentation

sealed class UsersEvent {
    object Update : UsersEvent()
    object LoadNew : UsersEvent()
}