package com.pchpsky.swivltesttask.feature_users.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import com.pchpsky.swivltesttask.feature_users.data.data_source.network.UsersNetworkClient
import java.lang.Exception


class UsersPagingSource(private val networkClient: UsersNetworkClient) : PagingSource<Int, UserListItem>() {
    override fun getRefreshKey(state: PagingState<Int, UserListItem>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserListItem> {
        val pageSince = params.key ?: 0

        return try {
            val users = networkClient.users(pageSince, params.loadSize)
            LoadResult.Page(
                data = users,
                prevKey = null,
                nextKey = users.last().id
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

}