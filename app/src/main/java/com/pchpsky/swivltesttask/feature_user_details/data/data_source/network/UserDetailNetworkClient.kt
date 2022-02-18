package com.pchpsky.swivltesttask.feature_user_details.data.data_source.network

import retrofit2.http.GET
import retrofit2.http.Query

interface UserDetailNetworkClient {

    @GET("users/")
    fun getUser(@Query("username") username: String)


}