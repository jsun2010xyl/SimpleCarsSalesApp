package com.example.simplecarssalesapp.data.network

import androidx.lifecycle.LiveData
import com.example.simplecarssalesapp.data.model.Item
import android.util.Log
import androidx.lifecycle.MutableLiveData
import java.lang.Exception

class NetworkDataSourceImpl(private val apiService: ItemApiService) : NetworkDataSource {
    private val _downloadedData = MutableLiveData<Item>()
    override val downloadedData: LiveData<Item>
        get() = _downloadedData

    override suspend fun fetchData() {
        try {
            val fetchedData = apiService.getItem().await()
            _downloadedData.postValue(fetchedData)
        }catch(e: Exception){
            Log.e("Connectivity", "No Internet connection.", e)
        }
    }
}