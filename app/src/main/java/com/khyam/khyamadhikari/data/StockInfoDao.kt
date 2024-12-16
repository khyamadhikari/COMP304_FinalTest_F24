package com.khyam.khyamadhikari.data

import androidx.room.*

@Dao
interface StockInfoDao {

    @Insert
    suspend fun insert(stock: StockInfo)

    @Update
    suspend fun update(stock: StockInfo)

    @Delete
    suspend fun delete(stock: StockInfo)

    @Query("SELECT * FROM stock_info")
    suspend fun getAllStocks(): List<StockInfo>
}
