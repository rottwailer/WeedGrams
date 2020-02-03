package com.example.weedgrams

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.weedgrams.databinding.FragmentGuiasBinding
import com.example.weedgrams.ui.interfaces.IComunicaFragments

class MainActivity : AppCompatActivity(), IComunicaFragments  {


    private lateinit var bindingGuias: FragmentGuiasBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_guias, R.id.navigation_principal, R.id.navigation_tiempo
            )
        )
        navView.setupWithNavController(navController)


    }

    override fun iniciarFragment() {

        Toast.makeText(applicationContext,"Iniciar Fragment",Toast.LENGTH_SHORT).show()


    }

}
