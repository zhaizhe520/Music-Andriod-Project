package com.example.androidvue.ui.pages.HomePages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class) // 启用长按功能需要的注解
@Composable
fun ChineseSongCard(
    name: String,                  // 👈 动态 Props：歌手名字
    desc: String,                  // 👈 动态 Props：歌手介绍
    isFavorite: Boolean,           // 👈 动态 Props：决定这颗星星是 “⭐” 还是 “☆”
    onLongClick: () -> Unit,       // 👈 动态 Emit：长按时通知父组件
    modifier: Modifier = Modifier,
    safeNavigate: (Any?) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp)
            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            // 🌟 核心改动：用 combinedClickable 替换 clickable，完美同时支持单击和长按！
            .combinedClickable(
                onClick = {
                    val item = null
                    safeNavigate(item) // 单击照常触发你的页面跳转
                },
                onLongClick = {
                    onLongClick() // 👈 长按时，直接把事件 Emit 出去
                }
            )
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // 🌟 1. 让人赏心悦目的 Emoji 星星组件
        Text(
            text = if (isFavorite) "⭐" else "☆",
            fontSize = 20.sp,
            color = if (isFavorite) Color(0xFFFFD700) else Color.Gray,
            modifier = Modifier.padding(end = 8.dp) // 给星星右边留点空隙，别挨着名字
        )

        // 2. 名字渲染
        Text(
            text = "$name：",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // 3. 介绍渲染
        Text(
            text = desc,
            fontSize = 13.sp,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
    }
}