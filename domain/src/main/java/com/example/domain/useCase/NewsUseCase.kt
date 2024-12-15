package com.example.domain.useCase

import android.util.Log
import com.example.domain.common.Resource
import com.example.domain.model.Article
import com.example.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend fun invoke(id: String): Flow<Resource<List<Article>?>> {


        return newsRepository.getNews(id)
    }
}