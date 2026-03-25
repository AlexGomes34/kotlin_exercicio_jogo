package com.example.quizatron_3000.componentes

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel

@Composable
fun Botao(numeroPerguntaViewModel: NumeroPerguntaViewModel, navController: NavController){
    val numeroP by numeroPerguntaViewModel.numeroPergunta.observeAsState(initial = 1)

    Button(modifier = Modifier
        .size(width = 330.dp, height = 60.dp)
        .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        onClick = {
            if(numeroP < 3){
                numeroPerguntaViewModel.onNumeroPerguntaChange(numeroP + 1)
                println(numeroP)
            }else{
                navController.navigate("resultado")
            }
        }) {
        Text(text = "Londres", color = Color.Black, textAlign = TextAlign.Start, fontSize = 25.sp)
    }
}