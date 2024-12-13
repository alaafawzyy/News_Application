package com.example.domain.repository

import com.example.domain.common.Resource
import com.example.domain.model.Source
import kotlinx.coroutines.flow.Flow

interface NewsSourceRepository {
    suspend fun getNewsSource(): Flow<Resource<List<Source>?>>
}