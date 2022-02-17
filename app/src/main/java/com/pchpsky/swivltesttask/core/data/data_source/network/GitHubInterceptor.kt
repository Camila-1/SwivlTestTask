package com.pchpsky.swivltesttask.core.data.data_source.network

import okhttp3.Interceptor
import okhttp3.Response

class GitHubInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader(
            "accept","application/vnd.github.v3+json"
        )
        return chain.proceed(request.build())
    }
}