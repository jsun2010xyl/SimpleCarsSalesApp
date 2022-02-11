package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class ServiceHistory(
    val history: List<HistoryX>,
    val icon: String,
    val iconUrl: String,
    val number: Int,
    val text: String
)