package com.example.simplecarssalesapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplecarssalesapp.data.db.entity.Car

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(carListEntry: List<Car>)

    @Query("select * from cars")
    fun getCars(): LiveData<List<Car>>
}