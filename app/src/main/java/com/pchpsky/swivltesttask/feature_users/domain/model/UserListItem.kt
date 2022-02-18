package com.pchpsky.swivltesttask.feature_users.domain.model

import com.squareup.moshi.Json

data class UserListItem(
    @field: Json(name = "id") val id: Int,
    @field: Json(name = "login") val login: String,
    @field: Json(name = "url") val url: String,
    @field: Json(name = "avatar_url") val avatarUrl: String,
)