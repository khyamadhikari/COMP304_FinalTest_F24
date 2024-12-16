package com.khyam.khyamadhikari.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khyam.khyamadhikari.ui.theme.StockAppTheme
import com.khyam.khyamadhikari.viewmodel.StockViewModel
import com.khyam.khyamadhikari.viewmodel.StockViewModelFactory
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Creating the StockViewModel instance
            val stockViewModel: StockViewModel = viewModel(
                factory = StockViewModelFactory(application)
            )

            // Applying StockAppTheme to UI
            StockAppTheme {
                // Calling StockScreen Composable with ViewModel
                StockScreen(viewModel = stockViewModel)
            }
        }
    }
}

@Composable
fun StockScreen(viewModel: StockViewModel) {
    // Observing stock list data
    val stockList by viewModel.allStocks.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        // Displaying each stock's information
        stockList.forEach { stock ->
            Text(text = "Symbol: ${stock.stockSymbol}")
            Text(text = "Company: ${stock.companyName}")
            Text(text = "Quote: ${stock.stockQuote}")
        }

        // Button to insert stock info (action to be added later)
        Button(onClick = {
            // Action for inserting stock info will be added later
        }) {
            Text(text = "Insert Stock Info")
        }
    }
}
