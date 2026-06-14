package com.example.androidvue.ui.navigation

import Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidvue.ui.pages.HomePages.MainAppScreen
import com.example.androidvue.ui.pages.SongScreen.chinese.ChineseSong
import com.example.androidvue.ui.pages.SongScreen.english.EnglishSong
import com.example.androidvue.ui.pages.SongScreen.japanese.JapaneseSong
import com.example.androidvue.ui.pages.SongScreen.japanese.JapaneseSongDetailScreen
import com.example.androidvue.ui.pages.SongScreen.japanese.LocalSongDetails
import com.example.androidvue.ui.pages.UserNav.UserHome
import com.example.androidvue.ui.pages.UserNav.MyFavorites

/**
 * 企业标准：统一路由管理
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Chinese : Screen("chinese")
    object English : Screen("english")
    object Japanese : Screen("japanese")
    object Login : Screen("login")
    object UserHome : Screen("userHome")
    object MyFavorites : Screen("myFavorites")
    // 在你的 Screen sealed class 里面加上这一行
    object JapaneseSongDetailScreen : Screen("JapaneseSongDetailScreen/{songId}")

}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            MainAppScreen(navController = navController)
        }
        composable(Screen.Chinese.route) {
            ChineseSong()
        }
        composable(Screen.English.route) {
            EnglishSong()
        }
        composable(Screen.Japanese.route) {
            JapaneseSong(navController = navController)
        }
        composable(Screen.Login.route) {
            Login(navController = navController)
        }
        composable(Screen.UserHome.route) {
            UserHome()
        }
        composable(Screen.MyFavorites.route) {
            MyFavorites()
        }
        // 修改你的 NavGraph 对应的 composable
        composable(Screen.JapaneseSongDetailScreen.route) { backStackEntry ->
            // 1. 抓取点击时传过来的 id 字符串（比如 "that_summer"）
            val songId = backStackEntry.arguments?.getString("songId") ?: ""

            // 2. 直接去前端的 LocalSongDetails 列表里查出对应的数据对象
            val currentSongData = LocalSongDetails.songList.find { it.id == songId }

            // 3. 把查出来的纯前端数据，喂给唯一的详情页
            if (currentSongData != null) {
                JapaneseSongDetailScreen(
                    songData = currentSongData,
                    navController = navController
                )
            }
        }
    }
}
