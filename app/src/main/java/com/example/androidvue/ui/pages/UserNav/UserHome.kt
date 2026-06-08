package com.example.androidvue.ui.pages.UserNav

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler // 🌟 确保导入了这个包
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserHome(modifier: Modifier = Modifier) {
    // 🌟 核心：在组件顶部获取当前环境的 UriHandler，用于空中打开网页
    val uriHandler = LocalUriHandler.current

    // 最外层用 Column 撑满全屏，并设置“淡粉色”背景
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFEEF2)), // 十六进制的淡粉色
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 顶部留出一点空间
        Spacer(modifier = Modifier.height(60.dp))

        // 圆形头像区域
        Box(
            modifier = Modifier
                .size(120.dp) // 头像整体大小
                .clip(CircleShape) // 裁剪成圆形
                .background(Color.White) // 先用白色垫底
                .border(3.dp, Color(0xFFFFB6C1), CircleShape) // 稍深一点的粉色边框
        ) {
            Text(
                text = "🐱",
                fontSize = 60.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 用户名
        Text(
            text = "Mashiro",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A4A4A) // 深灰色文字
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 个性签名 / 简介
        Text(
            text = buildAnnotatedString {
                // 1. 先加粗、变黑突出“技术栈”
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4A4A4A)
                )
                ) {
                    append("技术栈：")
                }
                // 2. 接着写后面的灰色小字
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("Vue框架 + Node.js后端 + MySQL + Kotlin + Jetpack Compose")
                }
            },
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 下方的数据卡片
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(16.dp)) // 圆角卡片
                .background(Color.White) // 卡片用纯白色
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InfoStatItem(count = "4", label = "Android项目")
            InfoStatItem(count = "10", label = "Vue项目")

            // 博客卡片：加上点击跳转逻辑
            InfoStatItem(
                count = "🌐",
                label = "我的博客",
                modifier = Modifier.clickable {
                    // 点击时，直接调用外部系统浏览器打开你的 Hexo 博客网址
                    uriHandler.openUri("https://zhaizhe520.github.io")
                }
            )
        }
    }
}

// 🌟 修正后的小组件：现在它能正确接收外部传进来的 modifier（包括 clickable 点击事件）了
@Composable
fun InfoStatItem(
    count: String,
    label: String,
    modifier: Modifier = Modifier // 👈 默认给个空的 Modifier 占位
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier // 👈 必须把传入的 modifier 绑定到最外层的 Column 上，这样整块区域点击才有效
    ) {
        Text(text = count, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF69B4)) // 粉色数字
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}