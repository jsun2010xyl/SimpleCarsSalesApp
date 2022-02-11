package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class VehicleUseHistory(
    val history: List<HistoryXX>,
    val icon: String,
    val iconUrl: String,
    val text: String
)