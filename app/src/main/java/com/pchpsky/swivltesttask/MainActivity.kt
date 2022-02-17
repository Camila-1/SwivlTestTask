package com.pchpsky.swivltesttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.pchpsky.swivltesttask.feature_users.presentation.UserListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, UserListFragment.newInstance())
        }
    }
}