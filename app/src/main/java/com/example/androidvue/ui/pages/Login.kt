import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController // 👈 别忘了导包
import com.example.androidvue.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    navController: NavController, // 🌟 1. 必须把路由控制器传进来
    modifier: Modifier = Modifier
) {
    // 状态控制：是否是注册状态
    var isRegister by remember { mutableStateOf(false) }

    // 输入框输入的数据
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // 用 Dialog 包裹整个页面，强行将层级提到最表面，压制底部的 NavButton
    Dialog(
        onDismissRequest = { /* 登录页不允许点空白处消失 */ },
        properties = DialogProperties(
            usePlatformDefaultWidth = false // 关键：允许内容真正撑满全屏
        )
    ) {
        // 使用 Surface 提供纯白背景，彻底遮挡外层的一切组件
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White // 这里强制设置为纯白
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // 标题：根据状态动态显示“登录”或“注册帐户”
                    Text(
                        text = if (isRegister) "注册帐户" else "欢迎登录",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // 用户名输入框
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("用户名/邮箱") },
                        leadingIcon = { Text("👤 ", modifier = Modifier.padding(start = 8.dp)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    // 密码输入框
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("密码") },
                        leadingIcon = { Text("🔒 ", modifier = Modifier.padding(start = 8.dp)) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    // 注册特有：确认密码输入框（仅在 isRegister 为 true 时显示）
                    if (isRegister) {
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("确认密码") },
                            leadingIcon = { Text("🔒 ", modifier = Modifier.padding(start = 8.dp)) },
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // 主按钮（登录 或 注册）
                    Button(
                        onClick = {
                            // 🌟 2. 移除所有账号密码验证，只要点击直接回 Home 页面！
                            navController.navigate(Screen.Home.route) {
                                // 顺便把登录页从返回栈里删掉，防止用户按返回键又回到登录页
                                popUpTo(Screen.Login.route) { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = if (isRegister) "立即注册" else "登 录")
                    }

                    // 状态切换文字：点击可以在“登录”和“注册”之间来回切换
                    Text(
                        text = if (isRegister) "已有账号？去登录" else "没有账号？立即注册",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                // 切换状态并清空输入的内容
                                isRegister = !isRegister
                                username = ""
                                password = ""
                                confirmPassword = ""
                            }
                    )
                }
            }
        }
    }
}