package com.example.weedgrams.ui.guias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentGuiasBinding

class GuiasFragment : Fragment() {

    private lateinit var notificationsViewModel: GuiasViewModel
    private lateinit var binding: FragmentGuiasBinding
    private lateinit var adapter: MainAdapter
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(GuiasViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_guias,container,false)
        notificationsViewModel =
            ViewModelProviders.of(this).get(GuiasViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_guias, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(this, Observer {
            textView.text = it
        })



        binding.recycledViewGuias.layoutManager = LinearLayoutManager(this.context)
        adapter = MainAdapter(this.context!!)
        binding.recycledViewGuias.setAdapter(adapter)
        observeData()


        return root
    }


    fun observeData(){
        viewModel.getListaGuias().observe(this, Observer {
            adapter.setListaData(it)
            adapter.notifyDataSetChanged()
        })
    }
}