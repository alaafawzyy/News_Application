package com.example.data.dataSource.news


import android.util.Log
import com.example.data.api.WebServices
import com.example.data.contract.news.NewsOnlineDataSource
import com.example.data.executeApi
import com.example.domain.model.Article
import javax.inject.Inject

class NewsOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):
    NewsOnlineDataSource {
    override suspend fun getNews(sourceId: String): List<Article>? {
        val response = executeApi { webServices.getNews(source = sourceId) }

        // التحقق إذا كانت النتيجة موجودة وتحديد الأخبار المتكررة
        return response?.articles
            ?.mapNotNull { it?.toArticle() }
            ?.distinctBy { it.url } // حذف الأخبار المتكررة باستخدام الـ URL كمفتاح
    }


}
