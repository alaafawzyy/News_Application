package com.example.data.model

data class NewsResponce(
    val articles: List<ArticleDto?>?,
    val status: String?,
    val totalResults: Int?,
)