package com.pchpsky.swivltesttask.feature_user_details.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.databinding.FragmentUserDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

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
                Picasso
                    .get()
                    .load(it.avatarUrl)
                    .placeholder(R.drawable.img)
                    .into(binding.userAvatar.avatar)
                binding.userLogin.text = it.login
                binding.userUrl.text = it.url
                binding.repositories.value.text = it.repositories
                binding.gists.value.text = it.gists
                binding.followers.value.text = it.followers
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}