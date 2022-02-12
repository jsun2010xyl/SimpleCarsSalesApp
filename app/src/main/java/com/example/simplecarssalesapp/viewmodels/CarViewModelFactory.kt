package com.example.simplecarssalesapp.viewmodels;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplecarssalesapp.data.repository.CarRepository

public class CarViewModelFactory(private val carRepository: CarRepository)
        : ViewModelProvider.NewInstanceFactory(){

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CarViewModel(carRepository) as T
        }

}
