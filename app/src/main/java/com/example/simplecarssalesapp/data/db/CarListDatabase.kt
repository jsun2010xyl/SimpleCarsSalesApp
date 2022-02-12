package com.example.simplecarssalesapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.simplecarssalesapp.data.db.entity.Car

@Database(entities = [Car::class], version = 1)
abstract class CarListDatabase: RoomDatabase(){
    abstract fun carDao() : CarDao

    companion object {
        @Volatile private var instance: CarListDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CarListDatabase::class.java, "itemdb.db")
                .build()
    }
}