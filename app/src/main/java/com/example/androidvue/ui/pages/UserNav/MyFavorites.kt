package com.example.androidvue.ui.pages.UserNav

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidvue.store.MusicViewModel
import com.example.androidvue.ui.pages.HomePages.ChineseSongCard

@Composable
fun MyFavorites() {
    // 🌟 核心修复：使用 Activity 级别的 ViewModel，确保全应用共享同一个“大管家”实例
    // 这样在 ChineseSong 里的收藏操作，MyFavorites 才能实时感知到
    val musicStore: MusicViewModel = viewModel(
        viewModelStoreOwner = LocalContext.current as ComponentActivity
    )

    // 🌟  2. 用 filter 把打勾收藏的歌手捞出来
    val favoriteArtists = remember {
        derivedStateOf { musicStore.artistList.filter { it.isFavorite } }
    }.value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "我的收藏 ⭐", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(10.dp))

        if (favoriteArtists.isEmpty()) {
            Text(text = "暂无收藏，快去长按歌手卡片吧~", color = Color.Gray)
        } else {
            LazyColumn {
                items(favoriteArtists) { artist ->
                    ChineseSongCard(
                        name = artist.name,
                        desc = artist.desc,
                        isFavorite = artist.isFavorite,
                        onLongClick = {
                            musicStore.toggleFavorite(artist.name)
                        },
                        safeNavigate = { /* 跳转逻辑 */ }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}
