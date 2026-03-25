package com.example.quizatron_3000.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.sp
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel

@Composable
fun Pergunta(numeroPerguntaViewModel: NumeroPerguntaViewModel){
    val numeroP by numeroPerguntaViewModel.numeroPergunta.observeAsState(initial = 1)

    Text(text = "Pergunta $numeroP de 3", fontSize = 25.sp)
}