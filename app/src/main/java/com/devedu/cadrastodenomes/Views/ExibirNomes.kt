package com.devedu.cadrastodenomes.Views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devedu.CadrastoDeNomes.Views.NomesAdapter
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.Room.NomesConstants
import com.devedu.cadrastodenomes.Views.Listener.NomesListener
import com.devedu.cadrastodenomes.viewmodel.NomesViewModel

class ExibirNomes : Fragment() {

    private lateinit var mViewModel:  NomesViewModel
    private val mAdapter: NomesAdapter = NomesAdapter()
    private lateinit var mListener: NomesListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(NomesViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_exibir_nomes, container, false)

        // Elemento de interface - RecyclerView
        // Não é possível deixar o Kotlin fazer o mapeamento, pois a fragment ainda não está totalmente criada
        // Assim, precisamos buscar o elemento através de findViewById
        val recycler = root.findViewById<RecyclerView>(R.id.RecyclerNomes)

        // Atribui um layout que diz como a RecyclerView se comporta
        recycler.layoutManager = LinearLayoutManager(context)

        // Defini um adapater - Faz a ligação da RecyclerView com a listagem de itens
        recycler.adapter = mAdapter

        // Cria os observadores
        observe()

        mListener = object : NomesListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, NomesFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(NomesConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.getAllNomes()
            }
        }

        // Retorna a Fragment criada
        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getAllNomes()
    }

    /**
     * Cria os observadores
     */
    private fun observe() {
        mViewModel.nomes.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}