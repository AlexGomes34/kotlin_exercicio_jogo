package com.example.quizatron_3000.componentes

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizatron_3000.PerguntacConteudo
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaAcertoViewModel
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Botao(
    numeroPerguntaViewModel: NumeroPerguntaViewModel,
    navController: NavController,
    texto: String,
    perguntacConteudo: String,
    numeroPerguntaAcertoViewModel: NumeroPerguntaAcertoViewModel,
    nomeManeiro: String
) {
    val numeroP by numeroPerguntaViewModel.numeroPergunta.observeAsState(initial = 1)
    var corBotao by remember { mutableStateOf(Color.White) }
    val scope = rememberCoroutineScope()

    Button(
        modifier = Modifier
            .size(width = 330.dp, height = 60.dp)
            .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = corBotao),
        onClick = {
            scope.launch {
                if (texto == perguntacConteudo) {
                    corBotao = Color.Green
                    numeroPerguntaAcertoViewModel.onNumeroPerguntaCertoChange(1)
                } else {
                    corBotao = Color.Red
                }
                delay(1000)
                corBotao = Color.White
                if (numeroP < 3) {
                    numeroPerguntaViewModel.onNumeroPerguntaChange(numeroP + 1)
                } else {
                    val acertos = numeroPerguntaAcertoViewModel.numeroPerguntaCerto.value ?: 0
                    navController.navigate("resultado/${nomeManeiro}/$acertos")
                }
            }
        }
    ) {
        Text(text = texto, color = Color.Black)
    }
}