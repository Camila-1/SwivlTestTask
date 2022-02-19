package com.pchpsky.swivltesttask.feature_user_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailFragment : Fragment() {

    companion object {
        fun newInstance(userName: String) = UserDetailFragment().apply {
            arguments = Bundle().apply { putString("user_name", userName) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = arguments?.getString("user_name")
        lifecycleScope.launchWhenCreated {
            viewModel.getUserDetail(userName!!)
        }
    }

    private val viewModel: UserDetailViewModelIml by viewModel()
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.user.collectLatest {
                if (it.login.isEmpty()) return@collectLatest
                Picasso
                    .get()
                    .load(it.avatarUrl)
                    .placeholder(R.drawable.img)
                    .into(binding.userAvatar.avatar)
                binding.userLogin.text = it.login
                binding.userUrl.text = it.url
                binding.repositories.value.text = it.repositories.toString()
                binding.gists.value.text = it.gists.toString()
                binding.followers.value.text = it.followers.toString()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}