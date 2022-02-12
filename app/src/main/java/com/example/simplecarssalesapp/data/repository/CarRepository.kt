package com.example.simplecarssalesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.simplecarssalesapp.data.db.entity.Car

interface CarRepository {
    suspend fun getCarList(): LiveData<List<Car>>
}