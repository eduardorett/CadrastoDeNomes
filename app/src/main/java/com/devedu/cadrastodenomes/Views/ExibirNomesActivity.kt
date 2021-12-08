package com.devedu.cadrastodenomes.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.Room.NomesEntity
import com.devedu.cadrastodenomes.viewmodel.NomesViewModel

class ExibirNomesActivity : AppCompatActivity() {

    private lateinit var mViewModel: NomesViewModel
    private var listaNomes: List<NomesEntity> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_nomes)

        mViewModel = ViewModelProvider(this).get(NomesViewModel::class.java)

        observe()
        getNomes()
    }

    fun getNomes(){
        mViewModel.getAllNomes()
    }

    private fun observe() {

        mViewModel.nomes.observe(this, androidx.lifecycle.Observer {

            listaNomes = it
            listaNomes.forEach {
                Log.d("EXIBIRNOMES", "Nome: "+it.nome)
            }

        })

    }
}