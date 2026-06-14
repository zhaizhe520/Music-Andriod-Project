package com.example.androidvue.ui.pages.SongScreen.japanese

import androidx.compose.ui.graphics.Color
// 注意引入你自己的 R 文件
// import com.yourpackage.R

// 1. 定义数据结构
data class LocalSong(
    val id: String,           // 路由要用的唯一字符串
    val title: String,        // 中文名
    val singer: String,       // 歌手
    val imageRes: Int,        // 圆形 Box 里要显示的图片资源
    val lyrics: List<String>, // 这首歌专属的歌曲数据
    val bgColor: Color        // 甚至给每首歌前端指定一个主题色
)

// 2. 在前端用一个 List 模拟你的本地“数据库”
object LocalSongDetails {
    val songList = listOf(
        LocalSong(
            id = "1",
            title = "",
            singer = "",
            imageRes = com.example.androidvue.R.drawable.user_logo, // 替换成你 drawable 里的图
            lyrics = listOf(

            ),
            bgColor = Color(0xFF121212) // 深色氛围
        ),
        LocalSong(
            id = "2",
            title = "Lemon",
            singer = "米津玄師",
            imageRes = com.example.androidvue.R.drawable.user_logo,
            lyrics = listOf(
                "夢ならばどれほどよかったでしょう",
                "未だにあなたのことを夢にみる",
                "忘れた物を取りに戻るように",
                "古びた思い出の埃を払う"
            ),
            bgColor = Color(0xFFFFFDF3) // 淡黄氛围
        ),
        LocalSong(
            id = "3",
            title = "ドライフラワー",
            singer = "优里",
            imageRes = com.example.androidvue.R.drawable.user_logo,
            lyrics = listOf(
                "多分、私じゃなくていいね",
                "余裕のない二人だったし",
                "お互いそっぽ向いてさ"
            ),
            bgColor = Color(0xFFF9F1F0) // 粉白氛围
        ),
        LocalSong(
            id = "4",
            title = "ドライフラワー",
            singer = "优里",
            imageRes = com.example.androidvue.R.drawable.user_logo,
            lyrics = listOf(
                "多分、私じゃなくていいね",
                "余裕のない二人だったし",
                "お互いそっぽ向いてさ"
            ),
            bgColor = Color(0xFFF9F1F0) // 粉白氛围
        )


    )
}