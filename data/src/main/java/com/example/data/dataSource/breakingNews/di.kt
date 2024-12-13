package com.example.data.dataSource.breakingNews

import com.example.data.contract.breakingnews.BreakingNewsOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsDataSourceBinder {
    @Binds
    abstract fun bindNewsOnlineDataSource(newsOnlineDataSourceImpl: BreakingNewsOnlineDataSourceImpl): BreakingNewsOnlineDataSource
}