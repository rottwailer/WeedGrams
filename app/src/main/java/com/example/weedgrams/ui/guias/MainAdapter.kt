package com.example.weedgrams.ui.guias

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weedgrams.R
import com.example.weedgrams.ui.comon.Guia
import kotlinx.android.synthetic.main.item_lista_guias_firebase.view.*

class MainAdapter(private val context : Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){



    private var dataList = mutableListOf<Guia>()

    fun setListaData(data :MutableList<Guia>){
        dataList = data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_lista_guias_firebase,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {

        return if(dataList.size >0){
              dataList.size
        }else{
             0
        }

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val guia: Guia = dataList[position]
        holder.bindView(guia)

    }

    inner class MainViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        fun bindView(guia: Guia){

            //Glide.with(context).load(guia.imageUrl).into(itemView.imageView) esto es para poner imagenes
            itemView.tituloCultivo.text = guia.tituloCultivo
            itemView.nivelDificultad.text = guia.dificultadValor
            itemView.dineroInvertido.text = guia.dineroInvertido
            itemView.tiempoInvertidoPlanta.text = guia.tiempoInvertido



        }

    }
}