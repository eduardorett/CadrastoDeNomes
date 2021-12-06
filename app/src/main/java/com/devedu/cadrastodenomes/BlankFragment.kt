package com.devedu.cadrastodenomes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devedu.CadrastoDeNomes.Views.Listener.NomesListener
import com.devedu.CadrastoDeNomes.Views.NomesAdapter
import com.devedu.cadrastodenomes.viewmodel.NomesViewModel
import com.devedu.cadrastodenomes.views.NomesFormActivity


class BlankFragment :Fragment(){


    private lateinit var mViewModel: NomesViewModel
    private val mAdapter: NomesAdapter = NomesAdapter()
    private lateinit var mListener: NomesListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this)[NomesViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_blank, container, false)

        // Elemento de interface - RecyclerView
        // Não é possível deixar o Kotlin fazer o mapeamento, pois a fragment ainda não está totalmente criada
        // Assim, precisamos buscar o elemento através de findViewById
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_nomes)

        // Atribui um layout que diz como a RecyclerView se comporta
        recycler.layoutManager = LinearLayoutManager(context)

        // Defini um adapater - Faz a ligação da RecyclerView com a listagem de itens
        recycler.adapter = mAdapter

        // Cria os observadores
        observe()

        mListener = object : NomesListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, NomesFormActivity::class.java)

                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
            }
        }

        // Retorna a Fragment criada
        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
    }

    /**
     * Cria os observadores
     */
    private fun observe() {
        mViewModel.nome.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}
