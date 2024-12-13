package com.example.data.repository.news

import com.example.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
 abstract class NewsRepoModulue {
     @Binds
     abstract fun bindNewsRepo(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}