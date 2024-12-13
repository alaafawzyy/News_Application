package com.example.data.database.local_datasource

import com.example.data.model.ArticleDto
import com.example.data.model.SourceDto
import com.example.data.database.DatabaseManager
import com.example.domain.model.Source
import javax.inject.Inject


class LocalDataSourceImpl @Inject constructor(private val databaseManager: DatabaseManager) : LocalDataSource {

    override suspend fun loadSources(): List<SourceDto?> {
        return databaseManager.sourcesDao().getSources()
    }




    override suspend fun saveArticles(list: List<ArticleDto?>) {
        val articlesList = list.map { it?.toArticle() }
        val articlesDBList = articlesList.map { it }

        val uniqueArticlesDBList = articlesDBList.distinctBy { it }

        databaseManager.articlesDao().addArticles(uniqueArticlesDBList)
    }






    override suspend fun saveSources(list: List<SourceDto?>) {
        val nonNullList = list.filter {
            return@filter it != null
        } as List<SourceDto>
        databaseManager.sourcesDao().addSources(nonNullList)
    }

    override suspend fun loadArticles(source: String): List<ArticleDto?> {
        val ardb = databaseManager.articlesDao().getAllArticles()
        return ardb
    }


}


