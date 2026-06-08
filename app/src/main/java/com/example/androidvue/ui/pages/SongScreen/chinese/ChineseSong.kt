package com.example.androidvue.ui.pages.HomePages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidvue.R // 🌟 确保你的 R 物理导包正确

@Composable
fun ChineseSong(modifier: Modifier = Modifier) {
    // 🌟 1. 最外层用 Box 撑满全屏，用来当做“舞台”
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // 🌟 2. 背景图：呆在 Box 的最底层，静静地铺满全屏
        Image(
            painter = painterResource(id = R.drawable.chinese),
            contentDescription = "背景图",
            contentScale = ContentScale.Crop,

            alpha = 0.5f, // 20% 透明度，很柔和
            modifier = Modifier.fillMaxSize()
        )

        // 🌟 3. 内容层：用 Column 把所有卡片垂直排好，叠在背景图的上面
        Column(
            modifier = Modifier

                .fillMaxSize()
                .padding(top = 40.dp) // 顶部留出一点呼吸空间
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp) // 👈 绝招：让每个卡片之间自动空出 12.dp 间距
        ) {
            ChineseSongCard(
                name = "周杰伦",
                desc = "华语乐坛标杆人物，创作型歌手，代表作《七里香》《青花瓷》《晴天》传唱至今。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "林俊杰",
                desc = "行走的CD，唱作全能歌手，代表作《江南》《修炼爱情》《不为谁而作的歌》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "毛不易",
                desc = "实力派创作歌手，曲风温柔治愈，代表作《消愁》《像我这样的人》《如果有一天我变得很有钱》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "薛之谦",
                desc = "深情唱作人，以情歌见长，代表作《演员》《认真的雪》《天外来物》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "陈奕迅",
                desc = "乐坛殿堂级歌手，嗓音极具故事感，代表作《浮夸》《十年》《孤勇者》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "周深",
                desc = "天籁嗓音，音域宽广风格多变，代表作《大鱼》《花开忘忧》《光亮》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "王菲",
                desc = "华语乐坛传奇女歌手，唱腔独特空灵，代表作《红豆》《匆匆那年》《暧昧》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "李荣浩",
                desc = "全能音乐制作人兼歌手，曲风简约有质感，代表作《年少有为》《模特》《乌梅子酱》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )
            ChineseSongCard(
                name = "张韶涵",
                desc = "极具穿透力的嗓音，励志金曲众多，代表作《隐形的翅膀》《欧若拉》《阿刁》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "许嵩",
                desc = "原创音乐人，曲风清新国风兼备，代表作《素颜》《断桥残雪》《雅俗共赏》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "孙燕姿",
                desc = "经典实力女歌手，歌声清澈治愈，代表作《开始懂了》《遇见》《我怀念的》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "王力宏",
                desc = "全能唱作歌手，曲风多元融合，代表作《龙的传人》《大城小爱》《唯一》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "徐佳莹",
                desc = "嗓音细腻富有情感，唱功扎实，代表作《失落沙洲》《身骑白马》《一样的月光》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "胡夏",
                desc = "清澈少年音，情歌氛围感拉满，代表作《那些年》《知否知否》《夏至未至》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "田馥甄",
                desc = "嗓音清冷独特，歌曲氛围感十足，代表作《小幸运》《魔鬼中的天使》《还是要幸福》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "陶喆",
                desc = "华语R&B教父，创作风格前卫，代表作《爱很简单》《普通朋友》《Melody》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "郁可唯",
                desc = "实力唱将，唱功细腻稳当，代表作《时间煮雨》《路过人间》《知否知否》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "张杰",
                desc = "高音极具爆发力，舞台表现力强，代表作《逆战》《这，就是爱》《天下》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )
            ChineseSongCard(
                name = "蔡依林",
                desc = "华语乐坛百变天后，唱跳实力出众，代表作《日不落》《舞娘》《大艺术家》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "五月天",
                desc = "知名摇滚乐团，歌曲充满青春与热血，代表作《倔强》《温柔》《后来的我们》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "朴树",
                desc = "民谣摇滚音乐人，曲风质朴纯粹，代表作《平凡之路》《那些花儿》《白桦林》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "杨丞琳",
                desc = "音色清甜，情歌感染力强，代表作《暧昧》《左边》《年轮说》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "伍佰",
                desc = "摇滚实力派，嗓音沧桑有故事，代表作《挪威的森林》《浪人情歌》《突然的自我》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "陈粒",
                desc = "风格独特的独立音乐人，唱腔洒脱不羁，代表作《奇妙能力歌》《小半》《走马》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "林宥嘉",
                desc = "嗓音迷幻深情，擅长演绎走心情歌，代表作《说谎》《成全》《眼色》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "莫文蔚",
                desc = "声线慵懒别致，韵味十足，代表作《阴天》《忽然之间》《这世界那么多人》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "汪苏泷",
                desc = "新生代创作歌手，曲风轻快多元，代表作《不分手的恋爱》《年轮》《一笑倾城》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "任贤齐",
                desc = "经典国民歌手，歌曲传唱度极高，代表作《心太软》《伤心太平洋》《天涯》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "刘若英",
                desc = "歌声温婉治愈，满含生活情愫，代表作《后来》《为爱痴狂》《原来你也在这里》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )

            ChineseSongCard(
                name = "萧敬腾",
                desc = "嗓音高亢爆发力强，被称雨神，代表作《王妃》《海芋恋》《怎么说我不爱你》。",
                safeNavigate = { /* 临时空着不报错 */ }
            )
        }
    }
}