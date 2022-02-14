package com.pchpsky.swivltesttask.core.data.data_source.network

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

const val BASE_URL = "https://api.github.com/"

val networkModule = module {
    factory { provideOkHttpClient() }
    factory {  }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .build()
}

