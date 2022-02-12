package com.example.simplecarssalesapp.data.network

import com.example.simplecarssalesapp.data.model.Item
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ItemApiService {

    @GET("assignment.json")
    fun getItem(

    ): Deferred<Item>

    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): ItemApiService {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://carfax-for-consumers.firebaseio.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory()) // for Deferred
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemApiService::class.java)
        }


    }
}