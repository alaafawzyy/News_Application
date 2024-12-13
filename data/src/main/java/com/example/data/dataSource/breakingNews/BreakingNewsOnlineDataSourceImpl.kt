package com.example.data.dataSource.breakingNews

import android.util.Log
import com.example.data.api.WebServices
import com.example.data.contract.breakingnews.BreakingNewsOnlineDataSource
import com.example.data.executeApi
import com.example.data.model.BreakingNewsDto
import com.example.domain.model.BreakingNews
import javax.inject.Inject

class BreakingNewsOnlineDataSourceImpl @Inject constructor(private val api: WebServices) : BreakingNewsOnlineDataSource {
    override suspend fun getBreakingNews(): List<BreakingNews>? {
        val response = executeApi { api.getBreakingNews() }

        if (response.isSuccessful) {
            val breakingNewsList = response.body()?.articles?.map { it.toBreakingNews() }
            return breakingNewsList
        } else {
            Log.e("a", "Error fetching breaking news: ${response.message()}")
            return null
        }
    }
}


