package com.devedu.cadrastodenomes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_exibir_nomes.*


class ExibirNomesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.devedu.cadrastodenomes.R.layout.activity_exibir_nomes)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, ExibirNomesFragment()).commit()
        }

    }

}