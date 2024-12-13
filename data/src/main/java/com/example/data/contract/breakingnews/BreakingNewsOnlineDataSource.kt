package com.example.data.contract.breakingnews

import com.example.domain.model.BreakingNews

interface BreakingNewsOnlineDataSource {
   suspend fun getBreakingNews():List<BreakingNews>?
}