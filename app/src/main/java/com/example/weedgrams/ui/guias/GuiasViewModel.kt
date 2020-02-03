package com.example.weedgrams.ui.guias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weedgrams.domain.firebase.Repo
import com.example.weedgrams.ui.comon.Guia

class GuiasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is guias Fragment"
    }
    val text: LiveData<String> = _text

    private val repo = Repo()

    fun getListaGuias():LiveData<MutableList<Guia>>{
        val mutableData = MutableLiveData<MutableList<Guia>>()
        repo.getGuiasData().observeForever{guias->

            mutableData.value = guias

        }
        return mutableData

    }
}