package com.example.weedgrams.ui.principal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment(){

    private lateinit var principalViewModel : PrincipalViewModel
    private lateinit var principalBinding: FragmentPrincipalBinding
    private lateinit var adapter: PrincipalMainAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        principalBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_principal,container,false)

        principalViewModel =
            ViewModelProviders.of(this).get(PrincipalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_principal, container, false)



        val adapter = PrincipalMainAdapter()
        principalBinding.list.adapter = adapter

        principalViewModel.getListaGuias().observe(this, Observer {



            it?.let {list->
                adapter.submitList(list)
            }
        })
        return root
    }
}