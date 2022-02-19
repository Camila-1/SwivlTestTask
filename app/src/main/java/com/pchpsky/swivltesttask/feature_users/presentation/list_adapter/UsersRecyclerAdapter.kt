package com.pchpsky.swivltesttask.feature_users.presentation.list_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.feature_users.domain.model.UserListItem
import com.pchpsky.swivltesttask.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UsersRecyclerAdapter(private val onClick: (userName: String) -> Unit) : PagingDataAdapter<UserListItem, UsersRecyclerAdapter.UsersViewHolder>(UserComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) = holder.bind(getItem(position)!!)

    inner class UsersViewHolder(private val userListView: ItemUserBinding) : RecyclerView.ViewHolder(userListView.root) {
        fun bind(user: UserListItem) = with(userListView) {
            root.setOnClickListener { onClick(user.login) }
            Picasso
                .get()
                .load(user.avatarUrl)
                .placeholder(R.drawable.img)
                .into(userAvatar.avatar)
            userLogin.text = user.login
        }
    }
}

object UserComparator : DiffUtil.ItemCallback<UserListItem>() {
    override fun areItemsTheSame(oldItem: UserListItem, newItem: UserListItem): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: UserListItem, newItem: UserListItem): Boolean = oldItem == newItem
}