package com.example.weedgrams.ui.registarse

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.e.InicioSesionActivity
import com.example.weedgrams.ui.MainActivity
import com.example.weedgrams.ui.comon.Usuario
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

class RegistrarseViewModel: ViewModel() {




    var usuario :String =""

    var contra:String = ""
    private  var database: DatabaseReference// ...


    fun writeNewUser () {
        val user = Usuario(usuario, contra)
        database.child("users").child(user.usuario).setValue(user.contra)
        //val usuarioToJson: Usuario = Usuario(user.usuario,user.contra)
        //val gson = Gson()
       // val json:String = gson.toJson(usuarioToJson)

    }

    init {
        database = FirebaseDatabase.getInstance().reference


    }

}