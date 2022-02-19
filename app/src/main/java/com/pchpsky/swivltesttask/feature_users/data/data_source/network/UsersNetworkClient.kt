package com.pchpsky.swivltesttask.feature_users.data.data_source.network

import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersNetworkClient {

    @GET("users")
    suspend fun users(
        @Query("since") since: Int,
        @Query("per_page") pageSize: Int
    ): List<UserListItem>
}