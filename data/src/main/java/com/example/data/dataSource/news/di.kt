package com.example.data.dataSource.news

import com.example.data.contract.news.NewsOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsDataSourceBinder {
    @Binds
    abstract fun bindNewsOnlineDataSource(newsOnlineDataSourceImpl: NewsOnlineDataSourceImpl): NewsOnlineDataSource
}