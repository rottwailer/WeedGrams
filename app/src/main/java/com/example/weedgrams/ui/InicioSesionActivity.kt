package com.e

import android.app.PendingIntent.getActivity
import android.content.Intent
import com.example.weedgrams.ui.MainActivity
import java.lang.Exception



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.weedgrams.R
import com.example.weedgrams.databinding.ActivityInicioSesionBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.io.File



class InicioSesionActivity : AppCompatActivity() {

    private lateinit var bindingInicioSession: ActivityInicioSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)
        val file: File = File("jsonUser.json")



        val navController = findNavController(R.id.nav_host_fragment)

        if(file.exists()){

            val background = object : Thread (){
                override fun run() {
                    try {
                        Thread.sleep(5000)
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
            background.start()
        }else{
            val background = object : Thread (){
                override fun run() {
                    try {
                        Thread.sleep(3000)

                        navController.navigate(R.id.action_logo_to_logearse)
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
            background.start()


        }

        }



}
