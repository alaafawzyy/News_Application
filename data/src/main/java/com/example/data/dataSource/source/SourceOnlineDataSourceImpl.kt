package com.example.data.dataSource.source

import com.example.data.api.WebServices
import com.example.data.contract.newsSource.NewsSourceOnlineDataSource
import com.example.data.executeApi
import com.example.domain.model.Source
import javax.inject.Inject

class SourceOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):
    NewsSourceOnlineDataSource {

    override suspend fun getNewsSource(): List<Source>? {
        val responce= executeApi { webServices.getNewsSource() }
         return responce?.filterNotNull()?.map {
            it.toSource()
        }
    }
}

