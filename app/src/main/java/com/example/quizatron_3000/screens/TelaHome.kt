package com.example.quizatron_3000.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron_3000.R

@Composable
fun TelaHome(navController: NavController, modifier: Modifier) {
    var nomeManeiro by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0, 255, 255)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(100.dp))
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "Broly",
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
        )
        Spacer(
            modifier = Modifier
                .size(80.dp)
        )
        Text(text = "QUIZATRON 3000", fontSize = 40.sp)
        Spacer(modifier = Modifier.size(60.dp))
        TextField(
            modifier = Modifier
                .size(width = 300.dp, height = 50.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp),
            value = nomeManeiro,
            onValueChange = {
                nomeManeiro = it
            }
        )
        Spacer(modifier = Modifier.size(60.dp))
        Button(
            modifier = Modifier
                .size(width = 300.dp, height = 50.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonColors(
                containerColor = Color(255, 215, 0),
                contentColor = Color.Black,
                disabledContainerColor = Color(255, 215, 0),
                disabledContentColor = Color.Black
            ),
            onClick = {
                navController.navigate("pergunta/$nomeManeiro")
            }
        ) {
            Text(text = "COMEÇAR!", fontSize = 20.sp)
        }
    }
}