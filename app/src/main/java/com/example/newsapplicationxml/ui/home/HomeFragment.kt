package com.example.newsapplicationxml.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.BreakingNews
import com.example.newsapplicationxml.databinding.FragmentHomeBinding
import com.example.newsapplicationxml.ui.home.adapter.BreakingNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeLiveData()
    }

    private fun observeLiveData() {lifecycleScope.launchWhenStarted {
        viewModel.product.collect { product ->
            product?.let {
                showBreakingNews(it)
            } }
        }
    }
    val breakingAdapter = BreakingNewsAdapter(null)
    private fun showBreakingNews(it:List<BreakingNews>?) {
        breakingAdapter.changeData(it)
    }

    private fun initView() {

        binding.rvBreakingNews.adapter = breakingAdapter
        viewModel.getBreakingNews()
    }

}