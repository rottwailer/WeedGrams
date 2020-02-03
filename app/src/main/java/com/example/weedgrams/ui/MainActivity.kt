package com.example.weedgrams.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weedgrams.R
import com.example.weedgrams.databinding.ActivityMainBinding
import com.example.weedgrams.databinding.FragmentGuiasBinding
import com.example.weedgrams.ui.guias.GuiasFragment
import com.example.weedgrams.ui.home.HomeFragment
import com.example.weedgrams.ui.interfaces.IComunicaFragments
import com.example.weedgrams.ui.principal.PrincipalFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IComunicaFragments  {


   // private lateinit var bindingMain: ActivityMainBinding
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->
       when(item.itemId){
           R.id.navigation_guias->{
               replaceFragment(GuiasFragment())
               Log.d("guias","guias")
               return@OnNavigationItemSelectedListener true
           }
           R.id.navigation_principal->{
               replaceFragment(PrincipalFragment())
               Log.d("principal","principal")
               return@OnNavigationItemSelectedListener true
           }
           R.id.navigation_tiempo->{
               replaceFragment(HomeFragment())
               Log.d("tiempo","tiempo")
               return@OnNavigationItemSelectedListener true
           }
       }
       return@OnNavigationItemSelectedListener false


   }

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment_main)
        navController.navigate(R.id.principalFragment)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
      /* val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_guias,
                R.id.navigation_principal,
                R.id.navigation_tiempo
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)*/



        navView.setupWithNavController(navController)


    }

    override fun iniciarFragment() {

        Toast.makeText(applicationContext,"Iniciar Fragment",Toast.LENGTH_SHORT).show()


    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_main,fragment)
        fragmentTransaction.commit()
    }
}
