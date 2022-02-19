package com.pchpsky.swivltesttask.feature_user_details.presentation

import com.pchpsky.swivltesttask.feature_user_details.domain.use_case.GetUser
import com.pchpsky.swivltesttask.feature_user_details.domain.use_case.UserDetailUseCases
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userDetailModule = module {
    factory { GetUser(get()) }
    factory { UserDetailUseCases(get()) }

    viewModel { UserDetailViewModelIml(get()) }
}