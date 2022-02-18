package com.pchpsky.swivltesttask.feature_users.data.data_source.network

import org.koin.dsl.module
import retrofit2.Retrofit

val usersNetworkModule = module {
    single { provideUsersNetworkClient(get()) }
}

private fun provideUsersNetworkClient(retrofit: Retrofit): UsersNetworkClient {
    return retrofit.create(UsersNetworkClient::class.java)
}
