package com.example.domain.repository

import com.example.domain.common.Resource
import com.example.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(sourceId:String): Flow<Resource<List<Article>?>>
}
