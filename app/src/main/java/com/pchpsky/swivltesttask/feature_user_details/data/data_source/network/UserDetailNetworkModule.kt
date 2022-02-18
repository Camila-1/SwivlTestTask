package com.pchpsky.swivltesttask.feature_user_details.data.data_source.network

import org.koin.dsl.module
import retrofit2.Retrofit

val userDetailNetworkModule = module{
    single { provideUserDetailNetworkClient(get()) }
}

private fun provideUserDetailNetworkClient(retrofit: Retrofit): UserDetailNetworkClient {
    return retrofit.create(UserDetailNetworkClient::class.java)
}
