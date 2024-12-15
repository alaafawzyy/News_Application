package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Source


@Entity(tableName = "sources")
data class SourceDto(
    @PrimaryKey
    @ColumnInfo
    val id_db: String,
    val category: String?,
    val country: String?,
    val description: String?,
    val id: String?,
    val language: String?,
    val name: String?,
    val url: String?
) {
    fun toSource(): Source {
        return Source(
            category, country, description, id, language, name, url
        )
    }
}
