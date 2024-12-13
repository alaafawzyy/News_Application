package com.example.data.repository.news

import com.example.data.contract.news.NewsOnlineDataSource
import com.example.data.database.ConnectivityChecker
import com.example.data.database.local_datasource.LocalDataSource
import com.example.data.mapper.toArticleDto
import com.example.data.model.ArticleDto
import com.example.data.toFlow
import com.example.domain.common.Resource
import com.example.domain.repository.NewsRepository
import com.example.domain.model.Article
import com.example.domain.model.Source
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(
    private val newsOnlineDataSource: NewsOnlineDataSource,
    private val localDataSource: LocalDataSource
): NewsRepository {
    override suspend fun getNews(sourceId: String): Flow<Resource<List<Article>?>> {
        if (ConnectivityChecker.isNetworkAvailable()) {
            val article = newsOnlineDataSource.getNews(sourceId = sourceId)
            if (article != null) {
                val nonNullArticles = article.map { toArticleDto(it) }
                localDataSource.saveArticles(nonNullArticles)

            }

            return toFlow { article }


        } else {
            val articlesFromDb = localDataSource.loadArticles(sourceId)
            return toFlow { articlesFromDb.filterNotNull().map { it!!.toArticle() } }
        }


    }}

