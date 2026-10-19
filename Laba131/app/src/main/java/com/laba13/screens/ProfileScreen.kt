package com.laba13.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laba13.R
import com.laba13.ui.theme.BlueText
import com.laba13.ui.theme.Gray
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun ProfileScreen(onBack: () -> Unit) {
    var isSubscribed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Аватар 120x120 по центру
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Аватар",
            modifier = Modifier.size(120.dp)
        )

        Spacer(Modifier.height(16.dp))

        // Имя: 22sp, bold, синий
        Text(
            text = "Айво Роботник",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = BlueText
        )

        Spacer(Modifier.height(16.dp))

        // Статус: 14sp, синий
        Text(
            text = "В сети",
            fontSize = 14.sp,
            color = Gray
        )

        Spacer(Modifier.height(16.dp))

        // Статистика: 3 элемента в ряд, равномерно
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Посты: 42", fontSize = 12.sp)
            Text("Подписчики: 1.2K", fontSize = 12.sp)
            Text("Подписки: 350", fontSize = 12.sp)
        }

        Spacer(Modifier.height(16.dp))

        // Кнопка: отступы по бокам 32dp
        Button(
            onClick = { isSubscribed = !isSubscribed },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSubscribed) Gray else MaterialTheme.colorScheme.primary
            )
        ) {
            Text(if (isSubscribed) "Вы подписаны" else "Подписаться", fontSize = 16.sp)
        }

        Spacer(Modifier.height(16.dp))

        TextButton(onClick = onBack) {
            Text("Назад")
        }
    }
}