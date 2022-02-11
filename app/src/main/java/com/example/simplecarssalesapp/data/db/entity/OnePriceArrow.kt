package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class OnePriceArrow(
    val arrow: String,
    val arrowUrl: String,
    val icon: String,
    val iconUrl: String,
    val order: Int,
    val text: String
)