package com.example.data.mapper


import com.example.data.model.ArticleDto
import com.example.data.model.SourceDto
import com.example.domain.model.Article
import com.example.domain.model.Source

fun toArticleDto(article: Article): ArticleDto {
        return ArticleDto(
            id = 0,
            publishedAt = article.publishedAt,
            author = article.author,
            urlToImage = article.urlToImage,
            description = article.description,
            title = article.title,
            url = article.url,
            content = article.content,
            source = toSourceDto(source = article.source?:Source("","","","","","",""))
            )
    }

fun toSourceDto(source: Source): SourceDto {
    return SourceDto(
        id_db = "", source.category, source.country, source.description, source.id
        , source.language, source.name, source.url
    )
}

