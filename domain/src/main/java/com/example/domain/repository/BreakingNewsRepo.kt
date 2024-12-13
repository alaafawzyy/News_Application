package com.example.domain.repository

import com.example.domain.common.Resource
import com.example.domain.model.BreakingNews
import kotlinx.coroutines.flow.Flow

interface BreakingNewsRepo {
    suspend fun getBreakingNews():Flow<Resource<List<BreakingNews>?>>

}