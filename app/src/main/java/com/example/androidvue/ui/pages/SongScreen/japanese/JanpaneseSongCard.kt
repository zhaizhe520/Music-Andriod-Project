package com.example.androidvue.ui.pages.SongScreen.japanese

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
// 注意换成你自己的 R 文件路径
// import com.example.yourapp.R

@Composable
fun ImageGridScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // 模拟 9 张图片的资源 ID 数组（记得替换成你 drawable 里的真实图片名）
        val imageList = listOf(
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
            com.example.androidvue.R.drawable.user_logo,
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 核心：固定每行 3 列
            horizontalArrangement = Arrangement.spacedBy(8.dp), // 左右间距
            verticalArrangement = Arrangement.spacedBy(8.dp)     // 上下间距
        ) {
            items(imageList.size) { index ->
                // 圆形图片 Box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f) // 保证 Box 是正方形
                        .clip(CircleShape) // 裁剪为圆形
                        .background(Color.LightGray), // 加个背景色防止图片加载前白屏
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imageList[index]),
                        contentDescription = "圆形图片",
                        contentScale = ContentScale.Crop, // 裁剪铺满，这样圆才好看
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}