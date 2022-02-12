package com.example.simplecarssalesapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.simplecarssalesapp.data.repository.CarRepository
import com.example.simplecarssalesapp.internal.lazyDeferred

class CarViewModel(private val carRepository: CarRepository)
    : ViewModel() {

    val carList by lazyDeferred {
        carRepository.getCarList()
    }
}