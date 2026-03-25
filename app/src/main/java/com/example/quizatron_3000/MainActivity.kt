package com.example.quizatron_3000

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizatron_3000.componentes.Botao
import com.example.quizatron_3000.componentes.Pergunta
import com.example.quizatron_3000.numeroPergunta.NumeroPerguntaViewModel
import com.example.quizatron_3000.screens.TelaHome
import com.example.quizatron_3000.screens.TelaPergunta
import com.example.quizatron_3000.screens.TelaResultado
import com.example.quizatron_3000.ui.theme.QUIZATRON_3000Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QUIZATRON_3000Theme {
                val navController = rememberNavController()
                val viewModel = NumeroPerguntaViewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Botao(
                        numeroPerguntaViewModel = viewModel,
                        navController = navController
                    )
                    Pergunta(
                        numeroPerguntaViewModel = viewModel
                    )

                    NavHost(
                        navController = navController,
                        startDestination = "inicio",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween (1000)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween (1000)
                            )
                        }
                    ){
                        composable (
                            route = "inicio"
                        ){
                            TelaHome(modifier = Modifier, navController = navController)
                        }
                        composable (route = "pergunta") {
                            TelaPergunta(modifier = Modifier, navController = navController, numeroPerguntaViewModel = viewModel)
                        }
                        composable(route = "resultado") {
                            TelaResultado(modifier = Modifier, navController = navController, numeroPerguntaViewModel = NumeroPerguntaViewModel())
                        }
                    }
                }
            }
        }
    }
}
