package com.example.androidvue.ui.pages.SongScreen.japanese

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.androidvue.R

@Composable
fun JapaneseSong(modifier: Modifier = Modifier,navController: NavController) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.japanese),
            contentDescription = "背景图",
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier= Modifier
        ) {

        }
        Column( modifier= Modifier) {
            ImageGridScreen(navController = navController)
        }

    }
}