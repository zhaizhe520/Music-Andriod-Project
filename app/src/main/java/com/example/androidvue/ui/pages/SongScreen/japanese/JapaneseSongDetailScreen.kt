package com.example.androidvue.ui.pages.SongScreen.japanese

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun JapaneseSongDetailScreen(
    songData: LocalSong, // 接收前端传过来的全套数据
    navController: NavHostController
) {
    // 整个页面的背景色直接用前端数据里配置的颜色
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(songData.bgColor)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 1. 动态显示歌曲名和歌手
            Text(text = songData.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = songData.singer, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(24.dp))

            // 2. 动态显示歌词列表
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(songData.lyrics) { line ->
                    Text(
                        text = line,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                }
            }

            // 3. 完美的 popBackStack 返回
            Button(onClick = { navController.popBackStack() }) {
                Text("返回列表")
            }
        }
    }
}
