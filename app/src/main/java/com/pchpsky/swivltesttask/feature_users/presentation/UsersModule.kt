package com.pchpsky.swivltesttask.feature_users.presentation

import com.pchpsky.swivltesttask.feature_users.data.repository.UsersRepositoryImpl
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import com.pchpsky.swivltesttask.feature_users.domain.use_case.GetUsers
import com.pchpsky.swivltesttask.feature_users.domain.use_case.UsersUseCases
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val usersModule = module{

    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single { GetUsers(get()) }
    factory { UsersUseCases(get()) }

    viewModel { UsersViewModelImpl(get()) }
}
