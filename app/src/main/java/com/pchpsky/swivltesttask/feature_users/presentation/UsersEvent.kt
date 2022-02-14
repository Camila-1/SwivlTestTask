package com.pchpsky.swivltesttask.feature_users.presentation

sealed class UsersEvent {
    object Refresh : UsersEvent()
    object LoadNew : UsersEvent()
}