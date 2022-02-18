package com.pchpsky.swivltesttask

import android.app.Application
import com.pchpsky.swivltesttask.core.data.data_source.network.networkModule
import com.pchpsky.swivltesttask.di.appModule
import com.pchpsky.swivltesttask.feature_user_details.data.data_source.network.userDetailNetworkModule
import com.pchpsky.swivltesttask.feature_user_details.data.repository.userDetailRepositoryModule
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.usersNetworkModule
import com.pchpsky.swivltesttask.feature_users.data.repository.usersRepositoryModule
import com.pchpsky.swivltesttask.feature_users.presentation.usersModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SwivlTestTaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@SwivlTestTaskApplication)
            modules(
                appModule,
                networkModule,
                usersModule,
                usersNetworkModule,
                userDetailNetworkModule,
                usersRepositoryModule,
                userDetailRepositoryModule
            )
        }
    }
}