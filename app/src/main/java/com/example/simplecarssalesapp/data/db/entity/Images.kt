package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class Images(
    val baseUrl: String,
    val firstPhoto: FirstPhoto,
    val large: List<String>,
    val medium: List<String>,
    val small: List<String>
)