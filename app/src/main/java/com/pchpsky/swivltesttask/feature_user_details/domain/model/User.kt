package com.pchpsky.swivltesttask.feature_user_details.domain.model

import com.squareup.moshi.Json

data class User(
    @field: Json(name = "id") val id: Int = 0,
    @field: Json(name = "login") val login: String = "",
    @field: Json(name = "url") val url: String = "",
    @field: Json(name = "avatar_url") val avatarUrl: String = "",
    @field: Json(name = "public_repos") val repositories: String = "",
    @field: Json(name = "public_gists") val gists: String = "",
    @field: Json(name = "followers") val followers: String = "",
) {

}
