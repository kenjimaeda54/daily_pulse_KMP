package com.example.dailypulse.android.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailypulse.Platform

data class ItemsPlatform(
    val description: String,
    val value: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplayInfoNameSystem() {

    val platform = Platform()
    val items = listOf(
        ItemsPlatform("Model device", platform.deviceModel),
        ItemsPlatform("System name", platform.osName),
        ItemsPlatform("System version", platform.osVersion),
        ItemsPlatform("Density", platform.density.toString()),
    )

    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        TopBarApp()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            items(items.size) {
                RowItemsPlatform(items[it])
            }
        }
    }

}

@Composable
fun TopBarApp() {
    Text(
        text = "About System", style = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    )

}

@Composable
fun RowItemsPlatform(item: ItemsPlatform) {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(
            text = item.description, style = TextStyle(
                fontWeight = FontWeight.Bold,
            )
        )
        Text(text = item.value)
        Divider(modifier = Modifier.padding(top = 10.dp))
    }
}



