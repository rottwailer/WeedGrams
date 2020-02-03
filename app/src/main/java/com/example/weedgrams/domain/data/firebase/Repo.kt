package com.example.weedgrams.domain.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weedgrams.ui.comon.Guia
import com.example.weedgrams.ui.comon.Usuario
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    val db = FirebaseFirestore.getInstance()

    fun getGuiasData(): LiveData<MutableList<Guia>> {

        val mutableData = MutableLiveData<MutableList<Guia>>()
        FirebaseFirestore.getInstance().collection("guias").get().addOnSuccessListener { result->

           val listData = mutableListOf<Guia>()
           for (document in result) {
               val tituloCultivo:String? = document.getString("tituloCultivo")
               Log.d("tituloCultivo",tituloCultivo)
               val fenotipoPlanta:String? = document.getString("fenotipoPlanta")
               Log.d("fenotipoPlanta",fenotipoPlanta)
               val dificultadValor:String? = document.getString("dificultadValor")
               Log.d("dificultadValor",dificultadValor)
               val dineroInvertido:String? = document.getString("dineroInvertido")
               Log.d("dineroInvertido",dineroInvertido)
               val tiempoInvertido:String? = document.getString("tiempoInvertido")
               Log.d("tiempoInvertido",tiempoInvertido)
               val guia = Guia(tituloCultivo!!, dineroInvertido!!, dificultadValor!!, tiempoInvertido!!, fenotipoPlanta!!)
                listData.add(guia)

           }
            mutableData.value = listData

        }
        return mutableData

    }

    fun obtenerUserData(datoABuscar:String,usuario:String):String{
        var datoConcreto:String = ""

        db.collection("usuarios").document(usuario).get().addOnSuccessListener { document->
            val dato:String
            if (document.exists()){
                //traer datos del documento
                 dato = document.data?.get(datoABuscar).toString()
                 datoConcreto = dato

            }else{
               // no existe el documento
            }

        }
        return datoConcreto


    }


}