package com.pchpsky.swivltesttask.core.domain.model

import com.squareup.moshi.Json

data class User(
    @field: Json(name = "id") val id: Int,
    @field: Json(name = "login") val login: String,
    @field: Json(name = "url") val url: String,
    @field: Json(name = "avatar_url") val avatarUrl: String,
)