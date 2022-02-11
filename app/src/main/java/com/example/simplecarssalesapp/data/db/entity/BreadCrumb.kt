package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class BreadCrumb(
    val label: String,
    val link: String,
    val position: Int
)