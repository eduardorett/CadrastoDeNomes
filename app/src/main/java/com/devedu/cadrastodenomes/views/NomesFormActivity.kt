package com.devedu.cadrastodenomes.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.viewmodel.NomesViewModel
import kotlinx.android.synthetic.main.nomesform_side.*


class NomesFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: NomesViewModel
    private var mNomeId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nomesform_side)

        mViewModel = ViewModelProvider(this).get(NomesViewModel::class.java)

        observe()
        listeners()

    }

    private fun listeners() {
        btnSalvar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btnSalvar) {
            handleSave()
        }
    }

    private fun handleSave() {
        val nomeInsert = insercaoDeNome.text.toString()


        mViewModel.addNome(nomeInsert, mNomeId)
    }


    private fun observe() {

        mViewModel.validation.observe(this, androidx.lifecycle.Observer {
            if (it) {
                if (mNomeId == 0) {
                    Toast.makeText(this, "Nome inserido", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Nome Atualizado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Insira um nome", Toast.LENGTH_SHORT).show()
            }
        })

    }


}