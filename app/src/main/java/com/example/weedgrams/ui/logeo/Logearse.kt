package com.example.weedgrams.ui.logeo


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentLogearseBinding
import com.example.weedgrams.ui.MainActivity
import com.example.weedgrams.ui.comon.Usuario
import com.example.weedgrams.ui.home.HomeViewModel
import com.example.weedgrams.ui.logo.logoDirections
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.File

/**
 * A simple [Fragment] subclass.
 */
class Logearse : Fragment() {

    private lateinit var bindingLogearse: FragmentLogearseBinding
    private lateinit var logearseViewModel: LogearseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//https://firebase.google.com/docs/database/android/read-and-write?hl=es
        //https://medium.com/knowing-android/animaciones-y-transiciones-en-android-parte-1-3bd2d2e9625d
        bindingLogearse = DataBindingUtil.inflate(inflater, R.layout.fragment_logearse,container,false)

        logearseViewModel = ViewModelProviders.of(this).get(LogearseViewModel::class.java)




        bindingLogearse.buttonRegister.setOnClickListener{
            this.findNavController().navigate(LogearseDirections.actionLogearseToFragmentRegistrarse())

        }
        bindingLogearse.buttonLoggin.setOnClickListener{


            logearseViewModel.usuario =bindingLogearse.usuarioLogeo.text.toString()
            logearseViewModel.contra = bindingLogearse.contraLogeo.text.toString()
            if (logearseViewModel.confirmarUserYContra()){
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)


            }else{
                Toast.makeText(context,"Usuario o contraseña erroneos porfavor introduzca otra vez los datos ",Toast.LENGTH_LONG).show()
            }


        }


        return bindingLogearse.root
    }





}
