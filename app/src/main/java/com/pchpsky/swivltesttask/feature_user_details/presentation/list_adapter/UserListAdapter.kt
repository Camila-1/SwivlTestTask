package com.pchpsky.swivltesttask.feature_user_details.presentation.list_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.feature_user_details.domain.model.User

class UserListAdapter(private val users: List<User>) : RecyclerView.Adapter<UserListAdapter.UsersViewHolder>() {

    override fun getItemCount(): Int = users.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) = holder.bind(users[position])

    inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) = with(itemView) {

        }
    }
}