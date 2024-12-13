package com.example.data.api



import com.example.data.model.ArticleDto
import com.example.data.model.BreakingNewsDto
import com.example.data.model.BreakingNewsResponse
import com.example.data.model.SourceDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WebServices {

    @GET("v2/top-headlines/sources")
    suspend fun getNewsSource(
        @Query("apiKey") apikey:String= Constants.apikey,
    ): List<SourceDto>

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apikey:String= Constants.apikey,
        @Query("sources")source:String,
    ):List<ArticleDto>

   @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("apiKey") apikey:String=Constants.apikey,
        @Query("country") country:String="us"
    ): Response<BreakingNewsResponse>
}