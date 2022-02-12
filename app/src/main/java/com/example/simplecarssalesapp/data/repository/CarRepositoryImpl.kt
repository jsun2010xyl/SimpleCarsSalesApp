package com.example.simplecarssalesapp.data.repository

import androidx.lifecycle.LiveData
import com.example.simplecarssalesapp.data.db.entity.Car
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.simplecarssalesapp.data.db.CarDao
import com.example.simplecarssalesapp.data.model.Item
import com.example.simplecarssalesapp.data.network.NetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class CarRepositoryImpl(
    private val carDao : CarDao,
    private val carNetworkDataSource : NetworkDataSource
) : CarRepository {

    init{
        carNetworkDataSource.downloadedData.observeForever { newCurrentItemList ->
            persistFetchedCurrentItemList(newCurrentItemList)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCarList(): LiveData<List<Car>> {
        return withContext(Dispatchers.IO){
            initItemList()
            return@withContext carDao.getCars()
        }
    }

    private fun persistFetchedCurrentItemList(fetchedItem: Item){
        GlobalScope.launch(Dispatchers.IO) {
            carDao.upsert(getCarList(fetchedItem))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun initItemList(){
        // TODO : if (true)
        if (true){
            fetchItemList()
            //Log.i("Msg", "Downloaded data from aws.")
        }
    }

    private suspend fun fetchItemList(){
        carNetworkDataSource.fetchData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun isFetchedItemListNeeded(lastFetchTime: ZonedDateTime): Boolean{
        val twoHrsAgo = ZonedDateTime.now().minusMinutes(120)
        return lastFetchTime.isBefore(twoHrsAgo)
    }
}