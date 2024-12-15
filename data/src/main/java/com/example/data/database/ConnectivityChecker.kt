package com.example.data.database

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object ConnectivityChecker {

    // سيتم تهيئة الـ context هنا في الـ Application class
    lateinit var context: Context

    // التأكد من توافر الشبكة
    fun isNetworkAvailable(): Boolean {
        // هنا التحقق من عدم تهيئة context ليس مطلوبًا بعد الآن لأننا نحتاجه من الـ Application
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if ((activeNetworkInfo != null) && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}
