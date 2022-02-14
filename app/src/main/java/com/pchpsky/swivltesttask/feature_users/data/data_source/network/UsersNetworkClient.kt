package com.pchpsky.swivltesttask.feature_users.data.data_source.network

import com.pchpsky.swivltesttask.core.domain.model.User
import retrofit2.http.GET

interface UsersNetworkClient {

    @GET("users")
    suspend fun users(): List<User>
}