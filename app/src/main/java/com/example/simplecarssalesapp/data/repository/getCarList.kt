package com.example.simplecarssalesapp.data.repository

import com.example.simplecarssalesapp.data.db.entity.Car
import com.example.simplecarssalesapp.data.model.Item

fun getCarList(item: Item): List<Car>{
    val carList = mutableListOf<Car>()
    item.listings.forEach {
        carList.add(Car(it.images.firstPhoto.large, it.bodytype,
        it.currentPrice, it.drivetype, it.engine, it.exteriorColor,
        it.interiorColor, it.make, it.mileage, it.model,
        it.transmission, it.trim, it.vin, it.year, item.searchArea.city,
        item.searchArea.state, it.dealer.phone))
    }
    return carList
}