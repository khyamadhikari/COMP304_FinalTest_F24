package com.khyam.khyamadhikari.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khyam.khyamadhikari.viewmodel.StockViewModel

// A factory for creating StockViewModel instances
class StockViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Return a StockViewModel instance, passing the application context
        return StockViewModel(application) as T
    }
}
