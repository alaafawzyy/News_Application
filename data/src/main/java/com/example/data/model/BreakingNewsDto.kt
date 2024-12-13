package com.example.data.model

import com.example.domain.model.BreakingNews
import com.example.domain.model.Source

data class BreakingNewsDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) {

    fun toBreakingNews(): BreakingNews {
        return BreakingNews(
            author = author ?: "Unknown",
            content = content,
            description = description,
            publishedAt = publishedAt,
            source = source,
            title = title,
            url = url,
            urlToImage = urlToImage ?: ""
        )
    }
}

data class BreakingNewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<BreakingNewsDto>
)
