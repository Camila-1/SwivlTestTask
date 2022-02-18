package com.pchpsky.swivltesttask.feature_users.data.repository

import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import org.koin.dsl.module

val usersRepositoryModule = module {
    factory<UsersRepository> { UsersRepositoryImpl(get()) }
}