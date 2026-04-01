package com.example.quizatron_3000.numeroPergunta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumeroPerguntaAcertoViewModel : ViewModel() {

    private val _numeroPerguntaCertoState = MutableLiveData<Int>(0)
    var numeroPerguntaCerto: LiveData<Int> = _numeroPerguntaCertoState

    fun onNumeroPerguntaCertoChange(novoNumero: Int) {
        _numeroPerguntaCertoState.value = _numeroPerguntaCertoState.value?.plus(novoNumero)

    }

    fun reiniciarQuiz(){
        _numeroPerguntaCertoState.value = 0
    }
}