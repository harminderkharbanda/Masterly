package com.harapps.masterly.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harapps.masterly.ui.components.SkillCartItem
import com.harapps.masterly.ui.theme.MasterlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterlyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        SkillCartItem("Guitar", "1,250", 0.13f, 13)
        SkillCartItem("JavaScript", "10,000", 1f, 100)
        SkillCartItem("Digital Painting", "2,250", 0.23f, 23)
        SkillCartItem("Spanish", "6,450", 0.65f, 65)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MasterlyTheme {
        Greeting()
    }
}