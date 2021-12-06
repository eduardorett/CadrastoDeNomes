package com.devedu.cadrastodenomes.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.devedu.cadrastodenomes.BlankFragment
import com.devedu.cadrastodenomes.R
import com.devedu.cadrastodenomes.R.id.nav_view
import com.devedu.cadrastodenomes.nav
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.actionbar))


        /*val ButtonOpen:Button=findViewById(R.id.buttonExibirNome)
        ButtonOpen.setOnClickListener {
            val myFragment = BlankFragment()
            val fragment : Fragment? =
                supportFragmentManager.findFragmentByTag(BlankFragment::class.java.simpleName)
            if(fragment !is BlankFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.LinearFragmentContainer,myFragment,BlankFragment::class.java.simpleName)
                    .commit()
            }
        }
*/
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