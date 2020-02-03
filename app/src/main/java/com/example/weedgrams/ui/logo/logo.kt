package com.example.weedgrams.ui.logo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentGuiasBinding
import com.example.weedgrams.databinding.FragmentLogoBinding
import java.io.File
import java.io.IOException
import java.io.InputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [logo.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [logo.newInstance] factory method to
 * create an instance of this fragment.
 */

private lateinit var bindingLogo: FragmentLogoBinding

class logo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingLogo = DataBindingUtil.inflate(inflater, R.layout.fragment_logo,container,false)

        val file:File = File("jsonUser.json")


        if(file.exists()){
            return bindingLogo.root


        }else{
           // goToLoginFragment()

        }
        return bindingLogo.root


//splash screen

    }

    private fun goToLoginFragment() {

        this.findNavController().navigate(logoDirections.actionLogoToLogearse())

    }
}
