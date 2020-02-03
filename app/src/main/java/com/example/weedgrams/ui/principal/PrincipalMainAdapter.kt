package com.example.weedgrams.ui.principal

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weedgrams.R
import com.example.weedgrams.databinding.FragmentPrincipalBinding
import com.example.weedgrams.databinding.ItemListaPlantasPrincipalBinding
import com.example.weedgrams.ui.comon.Plantas
import io.grpc.internal.SharedResourceHolder
import kotlinx.android.synthetic.main.item_lista_plantas_principal.view.*

class PrincipalMainAdapter: androidx.recyclerview.widget.ListAdapter<Plantas, PrincipalMainAdapter.ViewHolder>(PrincipalClassCallback()) {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from( parent)

    }





    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val planta:Plantas = getItem(position)
        val res = holder.itemView.context.resources
        holder.bindView(planta,res)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var binding: ItemListaPlantasPrincipalBinding
        var tituloPlantas: TextView = binding.tituloCultivo
        var fenotipoPlanta: TextView = binding.fenotipoPlanta
        var tiempoInvertido:TextView = binding.tiempoInvertidoPlanta
        fun bindView(planta: Plantas,res: Resources){

            tituloPlantas.text = planta.tituloCultivo
            fenotipoPlanta.text = planta.fenotipoPlanta
            tiempoInvertido.text = planta.tiempoInvertido




        }



        companion object {
            fun from( parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_lista_plantas_principal, parent, false)
                return ViewHolder(view)
            }
        }
    }
}
class PrincipalClassCallback:DiffUtil.ItemCallback<Plantas>(){
    override fun areItemsTheSame(oldItem: Plantas, newItem: Plantas): Boolean {

        return oldItem.tituloCultivo == newItem.tituloCultivo


    }

    override fun areContentsTheSame(oldItem: Plantas, newItem: Plantas): Boolean {

        return oldItem == newItem

    }


}