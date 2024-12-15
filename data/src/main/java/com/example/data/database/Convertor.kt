package com.example.data.database

import androidx.room.TypeConverter
import com.example.data.model.SourceDto
import com.google.gson.Gson


object Convertor {
    private val gson = Gson()

    @TypeConverter
    fun fromSourceDto(source: SourceDto?): String? {
        return if (source == null) null else gson.toJson(source)
    }

    @TypeConverter
    fun toSourceDto(sourceString: String?): SourceDto? {
        return if (sourceString == null) null else gson.fromJson(
            sourceString,
            SourceDto::class.java
        )
    }
}
