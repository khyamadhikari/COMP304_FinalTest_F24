package com.khyam.khyamadhikari.data

class StockRepository(private val stockInfoDao: StockInfoDao) {

    suspend fun insert(stock: StockInfo) {
        stockInfoDao.insert(stock)
    }

    suspend fun update(stock: StockInfo) {
        stockInfoDao.update(stock)
    }

    suspend fun delete(stock: StockInfo) {
        stockInfoDao.delete(stock)
    }

    suspend fun getAllStocks(): List<StockInfo> {
        return stockInfoDao.getAllStocks()
    }
}
