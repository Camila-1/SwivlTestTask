package com.pchpsky.swivltesttask.feature_users.data.data_source.network

import com.pchpsky.swivltesttask.feature_users.data.data_source.paging.UsersPagingSource
import org.koin.dsl.module
import retrofit2.Retrofit

val usersNetworkModule = module {
    single { provideUsersNetworkClient(get()) }
    single { providePagingSource(get()) }
}

fun provideUsersNetworkClient(retrofit: Retrofit): UsersNetworkClient {
    return retrofit.create(UsersNetworkClient::class.java)
}

fun providePagingSource(networkClient: UsersNetworkClient): UsersPagingSource {
    return UsersPagingSource(networkClient)
}