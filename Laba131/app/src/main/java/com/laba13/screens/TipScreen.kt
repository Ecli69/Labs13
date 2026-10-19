package com.laba13.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding

@Composable
fun TipScreen(onBack: () -> Unit) {
    var bill by remember { mutableStateOf("") }
    var percent by remember { mutableFloatStateOf(15f) }
    var people by remember { mutableStateOf("1") }

    val billValue = bill.toDoubleOrNull() ?: 0.0
    val peopleValue = people.toIntOrNull()?.takeIf { it > 0 } ?: 1

    val tip = billValue * percent / 100.0
    val total = billValue + tip
    val perPerson = total / peopleValue

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(24.dp)
    ) {
        Text("Сумма счёта:", fontSize = 18.sp)
        OutlinedTextField(
            value = bill,
            onValueChange = { bill = it },
            label = { Text("Введите сумму") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Text("Процент чаевых:", fontSize = 18.sp)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Slider(
                value = percent,
                onValueChange = { percent = it },
                valueRange = 0f..30f,
                modifier = Modifier.weight(1f)
            )
            Text("${percent.toInt()}%", fontSize = 18.sp)
        }

        Spacer(Modifier.height(16.dp))

        Text("Чаевые: ${"%.2f".format(tip)}₽", fontSize = 18.sp)
        Spacer(Modifier.height(16.dp))
        Text("Итого: ${"%.2f".format(total)}₽", fontSize = 18.sp)
        Spacer(Modifier.height(16.dp))
        Text("На человека: ${"%.2f".format(perPerson)}₽", fontSize = 18.sp)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = people,
            onValueChange = { people = it },
            label = { Text("Количество человек") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        TextButton(onClick = onBack) {
            Text("Назад")
        }
    }
}