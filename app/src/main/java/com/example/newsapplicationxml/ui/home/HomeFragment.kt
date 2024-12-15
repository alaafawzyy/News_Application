package com.example.newsapplicationxml.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.Article
import com.example.domain.model.BreakingNews
import com.example.domain.model.Source
import com.example.newsapplicationxml.R
import com.example.newsapplicationxml.databinding.FragmentHomeBinding
import com.example.newsapplicationxml.ui.home.adapter.BreakingNewsAdapter
import com.example.newsapplicationxml.ui.home.adapter.NewsAdapter
import com.google.android.material.tabs.TabLayout
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

    private fun observeLiveData() {
        lifecycleScope.launchWhenStarted {
        viewModel.breakingNews.collect { product ->
            product?.let {
                showBreakingNews(it)
            } }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.news.collect { product ->
                product?.let {

                    showNews(it)
                } }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.newsSource.collect { product ->
                product?.let {
                    showNewsSource(it)
                } }
        }
    }


    private fun showNewsSource(it: List<Source>) {

        it?.forEach { source ->
            val tab = binding.tabLayout.newTab()
            tab.text = source.name
            tab.tag = source
            binding.tabLayout.addTab(tab)
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.tabLayout.setTabTextColors(
                    ContextCompat.getColor(requireContext(), R.color.black),  // اللون الافتراضي للتاب
                    ContextCompat.getColor(requireContext(), R.color.blue)   // اللون الأزرق للتاب المحدد
                )
                binding.tabLayout.setSelectedTabIndicatorColor(
                    ContextCompat.getColor(requireContext(), R.color.blue)   // اللون الأزرق للمؤشر
                )
                val source = tab?.tag as Source
                val sourceName = source.id ?: ""
                if (sourceName.isNotEmpty()) {
                   viewModel.getNews(sourceName)
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val source = tab?.tag as Source
                val sourceName = source.name ?: ""
                if (sourceName.isNotEmpty()) {
                   viewModel.getNews(sourceName)
                }

            }
        })
    }


    val breakingAdapter = BreakingNewsAdapter(null)
    private fun showBreakingNews(it:List<BreakingNews>?) {
        breakingAdapter.changeData(it)
    }
val newsAdapter=NewsAdapter(newslist = null)
    private fun showNews(it: List<Article>) {
        newsAdapter.changeData(it)
        newsAdapter.notifyDataSetChanged()
    }

    private fun navigateToArticleDetails(article: Article) {
        val intent = Intent(requireContext(), ArticleDetailsActivity::class.java)
        intent.putExtra("passedArticle", article)
        Log.w("a","ssssssss $article")
        startActivity(intent)
    }

    private fun initView() {
         binding.viewall.setOnClickListener{
             val intent = Intent(requireContext(), NewsActivity::class.java)
             startActivity(intent)
         }
        binding.rvBreakingNews.adapter = breakingAdapter
        binding.newsRecycle.adapter=newsAdapter
        viewModel.getBreakingNews()
        viewModel.getNewsSource()
        viewModel.getNews("abc-news")
        newsAdapter.setOnArticleListener({article->
            navigateToArticleDetails (article)
        })

    }

}