package com.pchpsky.swivltesttask.feature_user_details.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userDetailModule = module {


    viewModel { UserDetailViewModelIml(get()) }
}