package com.pchpsky.swivltesttask.feature_users.presentation.list_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.core.domain.model.User
import com.pchpsky.swivltesttask.databinding.ItemUserBinding
import com.squareup.picasso.Picasso

class UserListAdapter() : PagingDataAdapter<User, UserListAdapter.UsersViewHolder>(UserComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) = holder.bind(getItem(position)!!)

    inner class UsersViewHolder(private val userListView: ItemUserBinding) : RecyclerView.ViewHolder(userListView.root) {
        fun bind(user: User) = with(userListView) {
            Picasso
                .get()
                .load(user.avatarUrl)
                .placeholder(R.drawable.img)
                .into(userAvatar)
            userLogin.text = user.login
        }
    }
}

object UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
}