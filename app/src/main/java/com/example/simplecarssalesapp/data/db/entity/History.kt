package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class History(
    val city: String,
    val endOwnershipDate: String,
    val ownerNumber: Int,
    val purchaseDate: String,
    val state: String
)