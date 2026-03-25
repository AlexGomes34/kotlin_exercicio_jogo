package com.example.quizatron_3000.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron_3000.R
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel


@Composable
fun TelaResultado(modifier: Modifier, navController: NavController, numeroPerguntaViewModel: NumeroPerguntaViewModel){
    Column(modifier = modifier
        .fillMaxSize()) {
        Spacer(modifier = Modifier.size(20.dp))
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.quiz),
                contentDescription = "quiz"
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Row(modifier = Modifier
            .fillMaxWidth()) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .height(200.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(modifier = Modifier
                    .size(height = 60.dp, width = 240.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color.Green)
                    .border(width = 1.dp, color = Color.Black, RoundedCornerShape(12.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Bom Trabalho", fontSize = 25.sp)
                }
                Text(text = "Voce acertou 1 de 3 perguntas", fontSize = 25.sp)
            }
        }
        Spacer(modifier = Modifier.size(40.dp))
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.size(width = 300.dp, height = 50.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(30.dp)),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonColors(containerColor = Color(255, 215, 0), contentColor = Color.Black, disabledContainerColor = Color(255, 215, 0), disabledContentColor = Color.Black),
                onClick = {
                    numeroPerguntaViewModel.onNumeroPerguntaChange(0)
                    navController.navigate("pergunta")
                }
            ) {
                Text(text = "JOGAR NOVAMENTE", fontSize = 20.sp)
            }
        }
    }
}