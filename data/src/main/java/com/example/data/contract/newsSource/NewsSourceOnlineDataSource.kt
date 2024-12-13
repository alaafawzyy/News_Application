package com.example.data.contract.newsSource

import com.example.domain.model.Source
interface NewsSourceOnlineDataSource {
    suspend fun getNewsSource():List<Source>?
}