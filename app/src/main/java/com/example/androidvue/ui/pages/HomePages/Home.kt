package com.example.androidvue.ui.pages.HomePages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidvue.R
import com.example.androidvue.ui.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * 1. 顶层页面组件 (Enterprise Standard: Main Entry)
 */
@Composable
fun MainAppScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // 抽屉导航组件
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            HomeDrawerContent(
                navController = navController,
                drawerState = drawerState,
                scope = scope
            )
        }
    ) {
        // 主页架子
        Scaffold(
            topBar = {
                HomeSearchBar(
                    onAvatarClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            }
        ) { innerPadding ->
            HomeMainContent(innerPadding)
        }
    }
}

/**
 * 2. 抽屉菜单内容 (Enterprise Standard: Modular Content)
 */
@Composable
fun HomeDrawerContent(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    // 防抖逻辑
    var lastClickTime by remember { mutableStateOf(0L) }
    fun safeNavigate(route: String) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > 500) {
            lastClickTime = currentTime
            scope.launch { drawerState.close() }
            navController.navigate(route) {
                launchSingleTop = true
            }
        }
    }

    ModalDrawerSheet(modifier = Modifier.width(240.dp)) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 背景图
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Drawer Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )

            // 菜单项
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // 顶部标题
                Text(
                    "菜单栏目",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                )

                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White
                )

                DrawerMenuItem("登录与注册") { safeNavigate(Screen.Login.route) }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White
                )

                DrawerMenuItem("个人中心") { safeNavigate(Screen.UserHome.route) }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White
                )

                DrawerMenuItem("我的收藏") { safeNavigate(Screen.MyFavorites.route) }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White
                )

                DrawerMenuItem("会员中心") { /* TODO */ }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DrawerMenuItem(label: String, onClick: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(label) },
        selected = false,
        onClick = onClick,
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}

/**
 * 3. 头部搜索组件
 */
@Composable
fun HomeSearchBar(
    modifier: Modifier = Modifier,
    onAvatarClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(0xFFA5EFEF))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 圆形头像
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .border(1.dp, Color(0xFF3B82F6), CircleShape)
                .clickable { onAvatarClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_logo),
                contentDescription = "User Avatar",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // 搜索框
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .weight(1f)
                .background(color = Color(0xFFB1D2EF))
                .heightIn(max = 50.dp),
            placeholder = {
                Text(text = "搜索你喜欢的音乐...", fontSize = 12.sp, color = Color.Black)
            },
            leadingIcon = {
                Text(text = "🔍", modifier = Modifier.padding(start = 12.dp), fontSize = 12.sp)
            },
            shape = RoundedCornerShape(4.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF3B82F6),
                unfocusedBorderColor = Color(0xFFE5E7EB)
            ),
            singleLine = true
        )
    }
}

/**
 * 4. 主页内容区域
 */
@Composable
fun HomeMainContent(paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        // 主页背景图
        Column {
            HomeCard()
        }
    }
}
