package com.example.simplecarssalesapp.ui

import kotlin.math.roundToInt

fun getYearMakeModelTrim(year: Int, make: String, model:String, trim:String): String{
    return year.toString() + " " + make + " " + model + " " + trim
}

fun getPriceMileage(price: Double, mileage: Int): String{
    return "$" + "%,d".format(price.roundToInt()) + "   |   " +
            (mileage/1000).toString() + "k mi"
}

fun getLocation(city:String, state:String): String{
    return city + ", " + state
}

fun getOtherInfo(
    exteriorColor: String,
    interiorColor: String,
    driveType: String,
    transmission: String,
    bodyStyle: String,
    engine: String,
    fuel: String
): String{
    return ""
}