package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.database.daos.ArticlesDao
import com.example.data.database.daos.SourcesDao
import com.example.data.model.ArticleDto
import com.example.data.model.SourceDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Database(entities = [SourceDto::class, ArticleDto::class], version = 5, exportSchema = false)
@TypeConverters(Convertor::class)
abstract class DatabaseManager : RoomDatabase() {
    abstract fun sourcesDao(): SourcesDao
    abstract fun articlesDao(): ArticlesDao
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): DatabaseManager {
        return Room.databaseBuilder(
            context.applicationContext,
            DatabaseManager::class.java,
            "news_database"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticlesDao(databaseManager: DatabaseManager): ArticlesDao {
        return databaseManager.articlesDao()
    }

    @Provides
    fun provideSourcesDao(databaseManager: DatabaseManager): SourcesDao {
        return databaseManager.sourcesDao()
    }
}
