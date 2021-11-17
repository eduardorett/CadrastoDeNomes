package com.devedu.CadrastoDeNomes.ViewModel


import android.app.Application
import androidx.lifecycle.*
import com.devedu.CadrastoDeNomes.Room.dao.NomesEntity
import com.devedu.CadrastoDeNomes.Repositorys.GuestRepository


class NomesViewModel(application: Application)  : AndroidViewModel(application){

    private val mContext = application.applicationContext
    private val nomesRepo: GuestRepository = GuestRepository(mContext)

    private val mValidation = MutableLiveData<Boolean>()
    val validation: LiveData<Boolean> = mValidation

    private var mNome = MutableLiveData<NomesEntity>()
    val nome: LiveData<NomesEntity> = mNome


    fun addNome(nomeInsert:String,id:Int) {
    val nome = NomesEntity().apply {
    this.id = id
    this.nome =nomeInsert
}
        when {
            id == 0 -> {
                nomesRepo.mInsert(nome)
                mValidation.value = true


            }
            id != 0 -> {
                nomesRepo.mUpdate(nome)
                mValidation.value=true
            }
            nomeInsert =="" -> {
                mValidation.value = false
            }
        }
}
}

