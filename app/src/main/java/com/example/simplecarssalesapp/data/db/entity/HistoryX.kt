package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class HistoryX(
    val city: String,
    val date: String,
    val description: String,
    val odometerReading: Int,
    val source: String,
    val state: String
)