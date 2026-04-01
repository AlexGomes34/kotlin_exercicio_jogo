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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron_3000.PerguntacConteudo
import com.example.quizatron_3000.R
import com.example.quizatron_3000.componentes.Botao
import com.example.quizatron_3000.componentes.Pergunta
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaAcertoViewModel
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel


@Composable
fun TelaPergunta(
    modifier: Modifier,
    navController: NavController,
    numeroPerguntaViewModel: NumeroPerguntaViewModel,
    numeroPerguntaAcertoViewModel: NumeroPerguntaAcertoViewModel,
    nomeManeiro: String?
) {
    val numeroP by numeroPerguntaViewModel.numeroPergunta.observeAsState(initial = 1)

    val pergunta = PerguntacConteudo(
        perguntaTexto = "Quantas esfereas do dragão existem?",
        perguntaResposta = listOf("1", "7", "9", "3"),
        respostaVerdade = "7"
    )
    val pergunta2 = PerguntacConteudo(
        perguntaTexto = "Quem sou eu?",
        perguntaResposta = listOf("criador", "homem", "mulher", "helicoptero"),
        respostaVerdade = "helicoptero"
    )
    val pergunta3 = PerguntacConteudo(
        perguntaTexto = "Qual é o verdadeiro nome do goku?",
        perguntaResposta = listOf("kakaroto", "gogeta", "cenora", "nappa"),
        respostaVerdade = "kakaroto"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(255, 141, 161)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Image(
            modifier = Modifier
                .size(80.dp)
                .fillMaxWidth(),
            painter = painterResource(R.drawable.quiz),
            contentDescription = "QUIZ"

        )
        Spacer(modifier = Modifier.size(50.dp))
        Row(
            modifier = Modifier
                .size(height = 60.dp, width = 250.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .background(Color.Green)
                .border(width = 1.dp, color = Color.Black, RoundedCornerShape(12.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Pergunta(numeroPerguntaViewModel)
        }
        Spacer(modifier = Modifier.size(10.dp))
        Card(
            modifier = Modifier
                .size(width = 380.dp, height = 430.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 25.dp, top = 30.dp, bottom = 30.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                if (numeroP == 1) {
                    Text(
                        text = pergunta.perguntaTexto,
                        textAlign = TextAlign.Start,
                        fontSize = 25.sp
                    )
                    pergunta.perguntaResposta.forEach { opcao ->
                        Botao(
                            numeroPerguntaViewModel, navController,
                            texto = opcao,
                            pergunta.respostaVerdade,
                            numeroPerguntaAcertoViewModel,
                            nomeManeiro = nomeManeiro!!
                        )
                    }
                } else if (numeroP == 2) {
                    Text(
                        text = pergunta2.perguntaTexto,
                        textAlign = TextAlign.Start,
                        fontSize = 25.sp
                    )
                    pergunta2.perguntaResposta.forEach { opcao ->
                        Botao(
                            numeroPerguntaViewModel, navController,
                            texto = opcao,
                            pergunta2.respostaVerdade,
                            numeroPerguntaAcertoViewModel,
                            nomeManeiro = nomeManeiro!!
                        )
                    }
                } else if (numeroP == 3) {
                    Text(
                        text = pergunta3.perguntaTexto,
                        textAlign = TextAlign.Start,
                        fontSize = 25.sp
                    )
                    pergunta3.perguntaResposta.forEach { opcao ->
                        Botao(
                            numeroPerguntaViewModel,
                            navController,
                            texto = opcao,
                            pergunta3.respostaVerdade,
                            numeroPerguntaAcertoViewModel,
                            nomeManeiro = nomeManeiro!!
                        )
                    }
                }
            }
        }
    }
}