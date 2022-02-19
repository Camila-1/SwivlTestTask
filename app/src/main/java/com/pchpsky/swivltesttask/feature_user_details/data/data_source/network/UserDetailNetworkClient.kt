package com.pchpsky.swivltesttask.feature_user_details.data.data_source.network

import com.pchpsky.swivltesttask.feature_user_details.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailNetworkClient {

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String) : User
}