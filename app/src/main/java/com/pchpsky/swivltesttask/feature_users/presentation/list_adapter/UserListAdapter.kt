package com.pchpsky.swivltesttask.feature_users.presentation.list_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.databinding.ItemUserBinding
import com.pchpsky.swivltesttask.core.domain.model.User
import com.squareup.picasso.Picasso

class UserListAdapter(private val users: List<User>) : RecyclerView.Adapter<UserListAdapter.UsersViewHolder>() {

    override fun getItemCount(): Int = users.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = ItemUserBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) = holder.bind(users[position])

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