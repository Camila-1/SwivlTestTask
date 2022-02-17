package com.pchpsky.swivltesttask.feature_users.presentation.list_adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pchpsky.swivltesttask.databinding.ItemLoadStateBinding

class UsersLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<UsersLoadStateAdapter.UsersLoadViewHolder>() {

    override fun onBindViewHolder(holder: UsersLoadViewHolder, loadState: LoadState) = holder.bind(loadState, retry)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): UsersLoadViewHolder {
        val item = ItemLoadStateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsersLoadViewHolder(item)
    }

    class UsersLoadViewHolder(private val itemLoadState: ItemLoadStateBinding)
        : RecyclerView.ViewHolder(itemLoadState.root) {
        fun bind(loadState: LoadState, retry: () -> Unit) {
            itemLoadState.retryButton.apply {
                isVisible = loadState is LoadState.Error
                setOnClickListener { retry() }
            }
            itemLoadState.progressBar.isVisible = loadState is LoadState.Loading
        }
    }
}