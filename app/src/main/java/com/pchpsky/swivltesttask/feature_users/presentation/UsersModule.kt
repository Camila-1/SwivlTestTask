package com.pchpsky.swivltesttask.feature_users.presentation

import com.pchpsky.swivltesttask.feature_users.data.repository.UsersRepositoryImpl
import com.pchpsky.swivltesttask.feature_users.domain.repository.UsersRepository
import com.pchpsky.swivltesttask.feature_users.domain.use_case.GetUsers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val usersModule = module{

    single<UsersRepository> { UsersRepositoryImpl() }
    single { GetUsers(get()) }

    viewModel { UsersViewModelImpl(get()) }
}
