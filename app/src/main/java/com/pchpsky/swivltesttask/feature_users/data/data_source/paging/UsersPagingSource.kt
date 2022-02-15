package com.pchpsky.swivltesttask.feature_users.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.UsersNetworkClient
import java.lang.Exception


class UsersPagingSource(private val networkClient: UsersNetworkClient) : PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val pageIndex = params.key ?: 1

        return try {
            val users = networkClient.users(pageIndex, params.loadSize)
            LoadResult.Page(
                data = users,
                prevKey = null,
                nextKey = pageIndex + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}