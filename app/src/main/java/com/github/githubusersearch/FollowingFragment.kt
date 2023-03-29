package com.github.githubusersearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.githubusersearch.databinding.FragmentFollowBinding

class FollowingFragment: Fragment(R.layout.fragment_follow) {
    private var _binding : FragmentFollowBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel: FollowingViewModel
    private lateinit var adapter: GithubUserAdapter
    private lateinit var username : String

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        username = args?.getString(DetailActivity.EXTRA_USERNAME).toString()
        _binding = FragmentFollowBinding.bind(view)

        adapter = GithubUserAdapter()
        adapter.notifyDataSetChanged()



        binding.apply {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(activity)
            rvUser.adapter = adapter
        }


        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[FollowingViewModel::class.java]
        viewModel.setListFollowing(username)

        viewModel.getListFollowing().observe(viewLifecycleOwner) {

            if (it != null) {
                adapter.setList(it)
                showLoading(true)
            }else(      showLoading(false))
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}