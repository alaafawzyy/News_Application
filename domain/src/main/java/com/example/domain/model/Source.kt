package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Source(
    val category: String?,
    val country: String?,
    val description: String?,
    val id: String?,
    val language: String?,
    val name: String?,
    val url: String? ): Serializable
