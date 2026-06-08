package com.example.androidvue.ui.pages.SongScreen.chinese

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidvue.R
import com.example.androidvue.store.MusicViewModel
import com.example.androidvue.ui.pages.HomePages.ChineseSongCard

@Composable
fun ChineseSong(modifier: Modifier = Modifier) {
    // 🌟 核心修复：同样使用 Activity 级别的 ViewModel
    val musicStore: MusicViewModel = viewModel(
        viewModelStoreOwner = LocalContext.current as ComponentActivity
    )

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.chinese),
            contentDescription = "背景图",
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // 循环遍历大管家里面的所有歌手
            musicStore.artistList.forEach { artist ->
                ChineseSongCard(
                    name = artist.name,
                    desc = artist.desc,
                    isFavorite = artist.isFavorite,
                    onLongClick = { musicStore.toggleFavorite(artist.name) },
                    safeNavigate = { /* 跳转逻辑 */ }
                )
            }
        }
    }
}
