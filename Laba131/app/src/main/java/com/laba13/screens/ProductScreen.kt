package com.laba13.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laba13.R
import com.laba13.ui.theme.Gray
import com.laba13.ui.theme.Green
import com.laba13.ui.theme.GreenDark
import com.laba13.ui.theme.Red
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.laba13.ui.theme.Blue600
import com.laba13.ui.theme.Blue700
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun ProductScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    var inCart by remember { mutableStateOf(false) }
    var inFav by remember { mutableStateOf(false) }
    var rating by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        // Фото 250dp
        Image(
            painter = painterResource(id = R.drawable.product),
            contentDescription = "Фото товара",
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Column(modifier = Modifier.padding(24.dp)) {
            // Название
            Text(
                "Sonic Racing Crossworlds STEAM ключ",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(16.dp))

            // Цена
            Text(
                "3 500 ₽",
                fontSize = 20.sp,
                color = Blue600
            )

            Spacer(Modifier.height(16.dp))

            // Описание
            Text(
                "Sonic Racing Crossworlds - динамичная гоночная аркада, в которой персонажи вселенной Соника (и приглашенные гости из других франшиз) соревнуются на земле, воде, в воздухе и даже в космосе!\n" +
                        "После оплаты Вы МОМЕНТАЛЬНО Получаете ключ от Steam Игры Sonic Racing: CrossWorlds (Standard Edition).\n" +
                        "Лучше чем Mario Kart World",
                fontSize = 14.sp
            )

            Spacer(Modifier.height(16.dp))

            // RatingBar
            Row {
                for (i in 1..5) {
                    IconButton(onClick = {
                        rating = i
                        Toast.makeText(context, "Вы поставили оценку: $i", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Звезда $i",
                            tint = if (i <= rating) Color(0xFFFFC107) else Color.LightGray
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Кнопки
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = {
                        inCart = !inCart
                        if (inCart) Toast.makeText(context, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (inCart) Gray else Blue600
                    )
                ) {
                    Text(if (inCart) "В корзине ✓" else "В корзину")
                }

                Button(
                    onClick = {
                        inFav = !inFav
                        if (inFav) Toast.makeText(context, "Добавлено в избранное", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (inFav) Red else Gray
                    )
                ) {
                    Text(if (inFav) "♥ В избранном" else "В избранное")
                }
            }

            Spacer(Modifier.height(16.dp))

            TextButton(onClick = onBack) {
                Text("Назад")
            }
        }
    }
}