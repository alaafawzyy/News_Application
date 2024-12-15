package com.example.newsapplicationxml.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.model.Article
import com.example.domain.model.BreakingNews
import com.example.domain.model.Source
import com.example.domain.useCase.BreakingNewsUseCase
import com.example.domain.useCase.NewsUseCase
import com.example.domain.useCase.SourceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val breakingUseCase: BreakingNewsUseCase,
    private val newsUseCase: NewsUseCase,
    private val newsSourceUseCase: SourceUseCase

):ViewModel() {

    private val _breakingNews = MutableStateFlow<List<BreakingNews>?>(null)
    val breakingNews: StateFlow<List<BreakingNews>?> get() = _breakingNews

    private val _news = MutableStateFlow<List<Article>?>(null)
    val news: StateFlow<List<Article>?> get() = _news

    private val _newsSource = MutableStateFlow<List<Source>?>(null)
    val newsSource: StateFlow<List<Source>?> get() = _newsSource


    fun getBreakingNews() {
        viewModelScope.launch(Dispatchers.IO) {
            breakingUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _breakingNews.value =
                            resource.data
                    }
                    else -> {
                        Log.w("HomeViewModel", "Error:${resource}")
                    }}}}}
    fun getNews(id: String) {
            viewModelScope.launch(Dispatchers.IO) {
                newsUseCase.invoke(id).collect { resource ->
                    when (resource) {
                        is Resource.Success -> {
                            _news.value = resource.data


                        }
                        else -> {
                            Log.w("HomeViewModel", "Error:${resource}")
                        }
                    }
                }
            }

    }

fun getNewsSource() {
    viewModelScope.launch(Dispatchers.IO) {
        newsSourceUseCase.invoke().collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    Log.w("a","aaaaaaa ${resource.data}")
                    _newsSource.value =resource.data
                }
                else -> {
                    Log.w("HomeViewModel", "Error:${resource}")

                }}}}


}}