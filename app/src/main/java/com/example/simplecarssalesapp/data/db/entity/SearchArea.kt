package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class SearchArea(
    val city: String,
    val dynamicRadii: List<Double>,
    val dynamicRadius: Boolean,
    val latitude: Double,
    val longitude: Double,
    val radius: Double,
    val state: String,
    val zip: String
)