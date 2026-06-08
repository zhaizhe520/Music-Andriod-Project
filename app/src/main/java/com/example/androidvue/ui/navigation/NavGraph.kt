package com.example.androidvue.ui.navigation

import Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidvue.ui.pages.HomePages.ChineseSong
import com.example.androidvue.ui.pages.HomePages.MainAppScreen
import com.example.androidvue.ui.pages.SongScreen.english.EnglishSong
import com.example.androidvue.ui.pages.SongScreen.japanese.JapaneseSong
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
            JapaneseSong()
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
    }
}
