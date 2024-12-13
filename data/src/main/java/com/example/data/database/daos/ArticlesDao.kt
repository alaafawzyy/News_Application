package com.example.data.database.daos


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.ArticleDto
import com.example.domain.model.Article


@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticles(list: List<Article?>)



    @Query("SELECT * FROM  articles_table ")
    suspend fun getAllArticles() :List<ArticleDto?>



}