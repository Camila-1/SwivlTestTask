package com.pchpsky.swivltesttask.feature_users.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pchpsky.swivltesttask.R
import com.pchpsky.swivltesttask.databinding.FragmentUserListBinding
import com.pchpsky.swivltesttask.feature_users.presentation.list_adapter.UsersLoadStateAdapter
import com.pchpsky.swivltesttask.feature_users.presentation.list_adapter.UsersRecyclerAdapter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    companion object {
        fun newInstance() = UserListFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    private val viewModel: UsersViewModelImpl by viewModel()
    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }


    @OptIn(InternalCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userList.layoutManager = LinearLayoutManager(requireContext())

        binding.userList.adapter = adapter.withLoadStateFooter(UsersLoadStateAdapter {
            adapter.retry()
        })
        lifecycleScope.launch {
            viewModel.users.collectLatest {
                adapter.submitData(it)
                binding.swipeRefresh.isRefreshing = false
            }
        }

        binding.swipeRefresh.setOnRefreshListener {
            adapter.refresh()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}