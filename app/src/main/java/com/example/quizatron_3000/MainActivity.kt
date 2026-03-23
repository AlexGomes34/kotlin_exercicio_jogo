package com.example.quizatron_3000

import android.media.audiofx.AudioEffect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizatron_3000.ui.theme.QUIZATRON_3000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUIZATRON_3000Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    telaPergunta(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun telaHome(modifier: Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0, 255, 255)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(100.dp))
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "Broly",
            modifier = Modifier.fillMaxWidth()
                .size(150.dp)
        )
        Spacer(modifier = Modifier
            .size(80.dp)
        )
        Text(text = "QUIZATRON 3000", fontSize = 40.sp)
        Spacer(modifier = Modifier.size(60.dp))
        Button(
            modifier = Modifier.size(width = 300.dp, height = 50.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonColors(containerColor = Color(255, 215, 0), contentColor = Color.Black, disabledContainerColor = Color(255, 215, 0), disabledContentColor = Color.Black),
            onClick = {}
        ) {
            Text(text = "COMEÇAR!", fontSize = 20.sp)
        }
    }
}
@Composable
fun telaPergunta(modifier: Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(255, 141, 161))
    ) {
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ"

        )
        Row(modifier = Modifier) {
            Text(text = "Pergunta 1 de 3")
        }
        Card(modifier = Modifier) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Qual é a capital da França?")
                Button(onClick = {}) {
                    Text(text = "Londres")
                }
                Button(onClick = {}) {
                    Text(text = "Londres")
                }
                Button(onClick = {}) {
                    Text(text = "Londres")
                }
                Button(onClick = {}) {
                    Text(text = "Londres")
                }
            }
        }
    }
}