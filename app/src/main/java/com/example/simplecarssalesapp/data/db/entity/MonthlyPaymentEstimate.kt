package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class MonthlyPaymentEstimate(
    val downPaymentAmount: Double,
    val downPaymentPercent: Double,
    val interestRate: Double,
    val loanAmount: Double,
    val monthlyPayment: Double,
    val price: Double,
    val termInMonths: Int
)