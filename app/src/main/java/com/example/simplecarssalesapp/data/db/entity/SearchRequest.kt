package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class SearchRequest(
    val make: String,
    val mileageRange: MileageRangeX,
    val model: String,
    val priceRange: PriceRange,
    val radius: Int,
    val srpUrl: String,
    val webHost: String,
    val yearRange: YearRangeX,
    val zip: String
)