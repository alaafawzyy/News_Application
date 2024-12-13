package com.example.data.repository.newsSource


import com.example.data.contract.newsSource.NewsSourceOnlineDataSource
import com.example.data.database.ConnectivityChecker
import com.example.data.database.local_datasource.LocalDataSource
import com.example.data.mapper.toSourceDto
import com.example.data.toFlow
import com.example.domain.common.Resource
import com.example.domain.repository.NewsSourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(private val sourceOnlineDataSource: NewsSourceOnlineDataSource,
                                               private val localDataSource: LocalDataSource
): NewsSourceRepository {
    override suspend fun getNewsSource(): Flow<Resource<List<com.example.domain.model.Source>?>> {
        if (ConnectivityChecker.isNetworkAvailable()) {
            val source = sourceOnlineDataSource.getNewsSource()
            if (source != null) {
                val nonNullArticles = source.map { toSourceDto(it) }
                localDataSource.saveSources(nonNullArticles)
            }

            return toFlow { source }


        } else {
            val articlesFromDb = localDataSource.loadSources()
           return toFlow { articlesFromDb.filterNotNull().map { it!!.toSource() } }

        }


    }

}