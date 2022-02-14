package com.pchpsky.swivltesttask

import android.app.Application
import com.pchpsky.swivltesttask.core.data.data_source.network.networkModule
import com.pchpsky.swivltesttask.di.appModule
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.usersNetworkModule
import com.pchpsky.swivltesttask.feature_users.presentation.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SwivlTestTaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SwivlTestTaskApplication)
            modules(
                appModule,
                networkModule,
                usersModule,
                usersNetworkModule
            )
        }
    }
}