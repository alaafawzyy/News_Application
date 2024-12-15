package com.example.newsapplicationxml.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.BreakingNews
import com.example.newsapplicationxml.R
import com.example.newsapplicationxml.databinding.ActivityNewsBinding
import com.example.newsapplicationxml.ui.home.adapter.BreakingNewsAdapter
import com.example.newsapplicationxml.ui.home.adapter.NewsSecondAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
         initView()
        observeLiveData()
        }

    private fun initView() {
        binding.newsRecycle.adapter=breakingAdapter
        viewModel.getBreakingNews()

    }

    private fun observeLiveData() {
        lifecycleScope.launchWhenStarted {
            viewModel.breakingNews.collect { product ->
                product?.let {
                    showBreakingNews(it)
                }
            }
        }}

        val breakingAdapter = NewsSecondAdapter(null)
        private fun showBreakingNews(it:List<BreakingNews>?) {
            breakingAdapter.changeData(it)
        }
}
