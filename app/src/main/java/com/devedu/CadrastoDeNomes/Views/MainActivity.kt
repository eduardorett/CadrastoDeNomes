package com.devedu.CadrastoDeNomes.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.devedu.CadrastoDeNomes.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.actionbar))

        nomeFormButton.setOnClickListener {
            startActivity(Intent(this, NomesFormActivity::class.java))
        }

    }



    override fun getSupportActionBar(): ActionBar? {
        return super.getSupportActionBar()
    }


    fun observer(){
        observer()
    }
}