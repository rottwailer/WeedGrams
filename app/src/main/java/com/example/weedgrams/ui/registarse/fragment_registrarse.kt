package com.example.weedgrams.ui.registarse


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentFragmentRegistrarseBinding
import com.example.weedgrams.ui.MainActivity
import com.example.weedgrams.ui.logeo.LogearseDirections
import com.example.weedgrams.ui.logeo.LogearseViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass.
 */
class fragment_registrarse : Fragment() {


    private lateinit var registrarseViewModel: RegistrarseViewModel
    private lateinit var bindingRegistarse: FragmentFragmentRegistrarseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registrarseViewModel = ViewModelProviders.of(this).get(RegistrarseViewModel::class.java)

        bindingRegistarse = DataBindingUtil.inflate(inflater, R.layout.fragment_fragment_registrarse,container,false)



        bindingRegistarse.buttonRegister.setOnClickListener{
            registrarseViewModel.usuario =bindingRegistarse.usuarioRegister.text.toString()
            registrarseViewModel.contra = bindingRegistarse.contraRegister.text.toString()
            registrarseViewModel.writeNewUser()
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)


        }


        // Inflate the layout for this fragment
        return bindingRegistarse.root
    }


}
