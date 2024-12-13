package com.example.domain.useCase

import android.util.Log
import com.example.domain.common.Resource
import com.example.domain.model.BreakingNews
import com.example.domain.repository.BreakingNewsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreakingNewsUseCase @Inject constructor(private val breakingNews: BreakingNewsRepo) {

    suspend fun invoke(): Flow<Resource<List<BreakingNews>?>> {
        return breakingNews.getBreakingNews()
    }
}