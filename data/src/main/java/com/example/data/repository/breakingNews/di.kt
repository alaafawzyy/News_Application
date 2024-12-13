package com.example.data.repository.breakingNews


import com.example.domain.repository.BreakingNewsRepo
import com.example.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
 abstract class NewsRepoModulue {
     @Binds
     abstract fun bindNewsRepo(breakingNewsRepoImpl: BreakingNewsRepoImpl):BreakingNewsRepo

}