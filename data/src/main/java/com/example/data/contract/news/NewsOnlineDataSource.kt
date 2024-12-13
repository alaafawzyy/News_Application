package com.example.data.contract.news

import com.example.domain.model.Article


interface NewsOnlineDataSource {
    suspend fun getNews(sourceId:String):List<Article>?
}