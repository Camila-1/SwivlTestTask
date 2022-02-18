package com.pchpsky.swivltesttask.feature_user_details.data.repository

import com.pchpsky.swivltesttask.feature_user_details.domain.repository.UserDetailRepository
import org.koin.dsl.module

val userDetailRepositoryModule = module {
    factory<UserDetailRepository> { UserDetailRepositoryImpl(get()) }
}