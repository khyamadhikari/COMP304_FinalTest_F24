package com.khyam.khyamadhikari.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.khyam.khyamadhikari.ui.theme.StockAppTheme

class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockAppTheme {
                DisplayStockScreen()
            }
        }
    }
}

@Composable
fun DisplayStockScreen() {
    // Simple static text to show stock information
    Text(text = "Stock Information")

    // Button to go back to MainActivity
    Button(onClick = {
        // Logic to go back to MainActivity can be added here
    }) {
        Text("Back to Main Activity")
    }
}
