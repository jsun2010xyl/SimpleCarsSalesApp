package com.example.simplecarssalesapp

import android.app.Application
import com.example.simplecarssalesapp.data.db.CarListDatabase
import com.example.simplecarssalesapp.data.network.*
import com.example.simplecarssalesapp.data.repository.CarRepository
import com.example.simplecarssalesapp.data.repository.CarRepositoryImpl
import com.example.simplecarssalesapp.viewmodels.CarViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class CarApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy{
        import (androidXModule(this@CarApplication))

        bind() from singleton { CarListDatabase(instance()) }
        bind() from singleton { instance<CarListDatabase>().carDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { CarApiService(instance()) }
        bind<NetworkDataSource>() with singleton { NetworkDataSourceImpl(instance()) }
        bind<CarRepository>() with singleton { CarRepositoryImpl(instance(), instance()) }
        bind() from provider { CarViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}