package com.example.data.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

class ProvideDB {

    @Module
    @InstallIn(SingletonComponent::class)  // Module سيتم استخدامه في SingletonComponent
    object DatabaseModule {

        // طريقة لتوفير الـ Context
        @Provides
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }


    }

}