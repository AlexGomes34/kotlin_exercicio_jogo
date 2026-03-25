package com.example.quizatron_3000.numeroPergunta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumeroPerguntaViewModel: ViewModel() {

    private val _numeroPerguntaState = MutableLiveData<Int>()
    var numeroPergunta: LiveData<Int> = _numeroPerguntaState

    fun onNumeroPerguntaChange(novoNumero: Int){
        _numeroPerguntaState.value = novoNumero
    }
}

