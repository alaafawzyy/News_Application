package com.example.data.model

import androidx.room.TypeConverter
import com.example.domain.model.Source
import com.google.gson.Gson


class Converters {

    @TypeConverter
    fun fromSource(source: Source?): String? {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun toSource(sourceString: String?): Source? {
        return Gson().fromJson(sourceString, Source::class.java)
    }
}