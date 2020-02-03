package com.example.weedgrams.ui.principal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weedgrams.domain.firebase.Repo
import com.example.weedgrams.ui.comon.Guia
import com.example.weedgrams.ui.comon.Plantas

class PrincipalViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val repo:Repo = Repo()

    fun getListaGuias():LiveData<MutableList<Plantas>>{
        val mutableData = MutableLiveData<MutableList<Plantas>>()
        repo.getGuiasData().observeForever{plantas->

          //  mutableData.value = plantas

        }
        return mutableData

    }
}