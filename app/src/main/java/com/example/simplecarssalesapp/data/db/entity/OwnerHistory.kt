package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class OwnerHistory(
    val history: List<History>,
    val icon: String,
    val iconUrl: String,
    val text: String
)