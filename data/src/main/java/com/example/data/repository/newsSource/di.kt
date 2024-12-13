package com.example.data.repository.newsSource


import com.example.domain.repository.NewsSourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class sourceRepoModulue {
    @Binds
    abstract fun bindNewsRepo(sourceRepositoryImpl: SourceRepositoryImpl): NewsSourceRepository
}