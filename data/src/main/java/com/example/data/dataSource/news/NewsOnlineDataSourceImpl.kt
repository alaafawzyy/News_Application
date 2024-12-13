package com.example.data.dataSource.news


import com.example.data.api.WebServices
import com.example.data.contract.news.NewsOnlineDataSource
import com.example.data.executeApi
import com.example.domain.model.Article
import javax.inject.Inject

class NewsOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):
    NewsOnlineDataSource {

    override suspend fun getNews(sourceId: String): List<Article>? {
        val responce= executeApi { webServices.getNews(source =sourceId) }
        return responce?.filterNotNull()?.map {
            it.toArticle()
        }
    }

}
