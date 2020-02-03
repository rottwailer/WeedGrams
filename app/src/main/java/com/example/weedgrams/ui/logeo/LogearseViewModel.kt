package com.example.weedgrams.ui.logeo

import android.text.Editable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentLogearseBinding
import com.example.weedgrams.domain.firebase.Repo
import com.example.weedgrams.ui.comon.Usuario
import com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import org.json.JSONObject

class LogearseViewModel : ViewModel() {

    var usuario: String = ""
    var contra: String = ""
    val repo :Repo= Repo()
    init {
      //  database = FirebaseDatabase.getInstance().reference



    }
    fun confirmarUserYContra():Boolean{

        if (contra ==repo.obtenerUserData("contra",usuario) && usuario ==repo.obtenerUserData("usuario",usuario)){

            val usuario:Usuario = Usuario(usuario,contra)
            val usuarioString:String = "{'usuario ': "+ usuario.usuario +", "+ "'contra' :"+ usuario.contra+"}"
            val gson = Gson()
            val usar = gson.fromJson(usuarioString, Usuario::class.java)
            val userString = gson.toJson(usar)


            return true

        }else{
            return false

        }

    }

    //que te den
    
}
