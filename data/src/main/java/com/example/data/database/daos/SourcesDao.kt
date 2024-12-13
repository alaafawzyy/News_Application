package com.example.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.SourceDto

@Dao
interface SourcesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSources(list: List<SourceDto>)

    @Query("delete from sources")
    suspend fun deleteOldList()
    @Query("select * from sources")
    suspend fun getSources():List<SourceDto?>
}