package com.example.newsapplicationxml

import android.app.Application
import com.example.data.database.ConnectivityChecker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        // تهيئة الـ context عند بدء التطبيق
        ConnectivityChecker.context = applicationContext
    }
}