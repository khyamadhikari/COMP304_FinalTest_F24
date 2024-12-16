package com.khyam.khyamadhikari

import android.app.Application
import androidx.room.Room
import com.khyam.khyamadhikari.data.AppDatabase

class MyApplication : Application() {
    // Room Database instance
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        // Initialize the Room Database here
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, // the database class
            "stock_database" // database name
        ).build()

        // Now the database is available globally for the app
    }
}
