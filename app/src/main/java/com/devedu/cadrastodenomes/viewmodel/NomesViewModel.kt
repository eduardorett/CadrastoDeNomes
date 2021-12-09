package com.devedu.cadrastodenomes.viewmodel


import android.app.Application
import androidx.lifecycle.*
import com.devedu.cadrastodenomes.room.NomesEntity
import com.devedu.cadrastodenomes.repositorys.NomesRepository


class NomesViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val nomesRepo: NomesRepository = NomesRepository(mContext)

    private val mValidation = MutableLiveData<Boolean>()
    val validation: LiveData<Boolean> = mValidation

    private var mNomes = MutableLiveData<List<NomesEntity>>()
    val nomes: LiveData<List<NomesEntity>> = mNomes


    fun addNome(nomeInsert: String, id: Int) {
        val nome = NomesEntity().apply {
            this.id = id
            this.nome = nomeInsert
        }
        if (id == 0 && nomeInsert != "") {
            nomesRepo.mInsert(nome)
            mValidation.value = true
        }
        if (id != 0 && nomeInsert != "") {
            nomesRepo.mUpdate(nome)
            mValidation.value = true
        }
        if (nomeInsert == "") {
            mValidation.value = false
        }

    }

    fun getAllNomes(){
        mNomes.value = nomesRepo.mGetAll()
    }


    fun delete(id:Int){
     nomesRepo.mDelete(id)
    }
}


