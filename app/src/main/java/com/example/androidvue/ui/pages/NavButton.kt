package com.example.androidvue.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidvue.ui.navigation.Screen

/**
 * 底部导航按钮组件 (Enterprise Standard)
 */
@Composable
fun NavButton(navController: NavHostController, modifier: Modifier = Modifier) {
    // 获取当前路由，用于自动设置选中状态
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // 防抖点击逻辑
    var lastClickTime by remember { mutableStateOf(0L) }
    fun safeNavigate(route: String) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > 500) {
            lastClickTime = currentTime
            navController.navigate(route) {
                // 回到首页时清除栈，避免堆积
                if (route == Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
                launchSingleTop = true
            }
        }
    }

    // 导航配置
    val navItems = listOf(
        NavigationItem(Screen.Home.route, "主页"),
        NavigationItem(Screen.Chinese.route, "中文歌"),
        NavigationItem(Screen.English.route, "英语歌"),
        NavigationItem(Screen.Japanese.route, "日语歌")
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFA6C7EE),
                        Color(0xFFE797C3),
                        Color(0xFF2EA3F1)
                    )
                )
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        navItems.forEach { item ->
            val isSelected = currentRoute == item.route

            Button(
                onClick = { safeNavigate(item.route) },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = if (isSelected) Color(0xFF3B82F6) else Color.Transparent
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0x33FFFFFF) else Color.Transparent,
                    contentColor = if (isSelected) Color(0xFF3B82F6) else Color.Black
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = item.label, fontSize = 12.sp, maxLines = 1)
            }
        }
    }
}

data class NavigationItem(val route: String, val label: String)
