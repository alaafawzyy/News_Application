package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Article
import com.example.domain.model.Source
import okio.`-DeprecatedOkio`.source

@Entity(tableName = "articles_table")
data class ArticleDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) {
    fun toArticle(): Article {
        return Article(
            author = author,
            content = content,
            description = description,
            publishedAt = publishedAt,
            source = source?.toSource(),
            title = title,
            url = url,
            urlToImage = urlToImage
        )
    }

}
