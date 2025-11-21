package com.harapps.masterly.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harapps.masterly.ui.screens.HomeScreen
import com.harapps.masterly.ui.theme.MasterlyTheme
import com.harapps.masterly.ui.theme.cardSurface
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterlyTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = cardSurface) { paddingValues ->
                    HomeScreen(paddingValues)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MasterlyTheme {
        HomeScreen(PaddingValues(16.dp))
    }
}