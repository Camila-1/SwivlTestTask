package com.pchpsky.swivltesttask.feature_users.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.databinding.FragmentUserListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    companion object {
        fun newInstance() = UserListFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    private var binding: FragmentUserListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        binding?.root

        return binding?.root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}