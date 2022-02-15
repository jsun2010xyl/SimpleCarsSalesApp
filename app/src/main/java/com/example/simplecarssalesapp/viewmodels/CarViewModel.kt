package com.example.simplecarssalesapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.simplecarssalesapp.data.db.entity.Car
import com.example.simplecarssalesapp.data.repository.CarRepository
import com.example.simplecarssalesapp.internal.lazyDeferred
import io.reactivex.rxjava3.core.Observable

class CarViewModel(private val carRepository: CarRepository)
    : ViewModel() {

    // Using Coroutines
    val carList by lazyDeferred {
        carRepository.getCarList()
    }

    // Using Rx
    fun getCars(): Observable<List<Car>> {
        return carRepository.getCars()
            .map { UsersList(it, "Users loaded successfully!") }
    }
}