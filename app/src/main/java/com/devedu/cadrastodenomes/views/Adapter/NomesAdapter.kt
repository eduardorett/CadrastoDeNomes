package com.devedu.CadrastoDeNomes.Views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devedu.cadrastodenomes.views.Listener.NomesListener
import com.devedu.cadrastodenomes.views.ViewHolder.NomesViewHolder
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.room.dao.NomesEntity

class NomesAdapter : RecyclerView.Adapter<NomesViewHolder>() {

    // Lista de convidados
    private var mGuestList: List<NomesEntity> = arrayListOf()
    private lateinit var mListener: NomesListener
    /**
     * Faz a criação do layout da linha
     * Faz a criação de várias linhas que vão mostrar cada um dos convidados
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NomesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_nomes, parent, false)
        return NomesViewHolder(item, mListener)
    }

    /**
     * Qual o tamanho da RecyclerView
     */
    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    /**
     * Para cada linha, este método é chamado
     * É responsável por atribuir os valores de cada item para uma linha específica
     */
    override fun onBindViewHolder(holder: NomesViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    /**
     * Atualização da lista de convidados
     */
    fun updateGuests(list: List<NomesEntity>) {
        mGuestList = list
        notifyDataSetChanged()
    }

    /**
     * Eventos na listagem
     */
    fun attachListener(listener: NomesListener) {
        mListener = listener
    }

}