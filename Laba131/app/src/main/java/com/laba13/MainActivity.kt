package com.laba13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.laba13.ui.theme.Laba13Theme
import com.laba13.screens.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laba13Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var screen by remember { mutableStateOf("menu") }

    when (screen) {
        "menu" -> MenuScreen(
            onProfile = { screen = "profile" },
            onRegister = { screen = "register" },
            onTip = { screen = "tip" },
            onProduct = { screen = "product" }
        )
        "profile" -> ProfileScreen(onBack = { screen = "menu" })
        "register" -> RegisterScreen(onBack = { screen = "menu" })
        "tip" -> TipScreen(onBack = { screen = "menu" })
        "product" -> ProductScreen(onBack = { screen = "menu" })
    }
}

@Composable
fun MenuScreen(
    onProfile: () -> Unit,
    onRegister: () -> Unit,
    onTip: () -> Unit,
    onProduct: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onProfile,
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Задание 1. Профиль")
        }
        Button(
            onClick = onRegister,
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Задание 2. Регистрация")
        }
        Button(
            onClick = onTip,
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Задание 3. Чаевые")
        }
        Button(
            onClick = onProduct,
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Задание 4. Товар")
        }
    }
}