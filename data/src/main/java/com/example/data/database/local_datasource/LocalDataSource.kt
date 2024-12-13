package com.example.data.database.local_datasource

import com.example.data.model.ArticleDto
import com.example.data.model.SourceDto
import com.example.domain.model.Article
import com.example.domain.model.Source



interface LocalDataSource {

   suspend fun loadSources() : List<SourceDto?>
    suspend fun saveSources(list : List<SourceDto?>)

    suspend fun loadArticles(source:String) : List<ArticleDto?>

    suspend fun saveArticles(list: List<ArticleDto?>)


}