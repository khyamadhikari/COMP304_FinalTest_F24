package com.khyam.khyamadhikari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khyam.khyamadhikari.data.AppDatabase
import com.khyam.khyamadhikari.data.StockInfo
import com.khyam.khyamadhikari.data.StockRepository
import kotlinx.coroutines.launch

class StockViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StockRepository
    val allStocks: LiveData<List<StockInfo>> get() = _allStocks
    private val _allStocks = MutableLiveData<List<StockInfo>>()

    init {
        val stockInfoDao = AppDatabase.getDatabase(application).stockInfoDao()
        repository = StockRepository(stockInfoDao)
        getAllStocks()  // Fetch all stocks when the ViewModel is created
    }

    fun insert(stock: StockInfo) {
        viewModelScope.launch {
            repository.insert(stock)
        }
    }

    fun update(stock: StockInfo) {
        viewModelScope.launch {
            repository.update(stock)
        }
    }

    fun delete(stock: StockInfo) {
        viewModelScope.launch {
            repository.delete(stock)
        }
    }

    private fun getAllStocks() {
        viewModelScope.launch {
            val stocks = repository.getAllStocks()
            _allStocks.postValue(stocks)  // Update LiveData with the fetched stocks
        }
    }
}
