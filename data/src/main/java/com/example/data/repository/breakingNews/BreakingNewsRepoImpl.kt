package com.example.data.repository.breakingNews
import android.util.Log
import com.example.data.contract.breakingnews.BreakingNewsOnlineDataSource
import com.example.data.toFlow
import com.example.domain.common.Resource
import com.example.domain.model.BreakingNews
import com.example.domain.repository.BreakingNewsRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BreakingNewsRepoImpl @Inject constructor(
    private val breakingNewsOnlineDataSource: BreakingNewsOnlineDataSource
) : BreakingNewsRepo {
    override suspend fun getBreakingNews(): Flow<Resource<List<BreakingNews>?>> {

        return toFlow { breakingNewsOnlineDataSource.getBreakingNews()}
    }}
