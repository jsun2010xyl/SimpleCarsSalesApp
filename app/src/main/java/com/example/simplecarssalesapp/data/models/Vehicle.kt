package com.example.simplecarssalesapp.data.models


data class Vehicle(
    val bodytype: String,
    val currentPrice: Double,
    val dealer: Dealer,
    val drivetype: String,
    val engine: String,
    val exteriorColor: String,
    val fuel: String,
    val images: Images,
    val interiorColor: String,
    val make: String,
    val mileage: Int,
    val model: String,
    val transmission: String,
    val trim: String,
    val vin: String,
    val year: Int
)