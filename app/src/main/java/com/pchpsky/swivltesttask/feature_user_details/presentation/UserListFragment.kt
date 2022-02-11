package com.pchpsky.swivltesttask.feature_user_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pchpsky.swivltesttask.databinding.FragmentUserlistBinding

class UserListFragment : Fragment() {

    companion object {
        fun newInstance(param1: String, param2: String) =
            UserListFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    private var binding: FragmentUserlistBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserlistBinding.inflate(inflater, container, false)
        return binding?.root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}