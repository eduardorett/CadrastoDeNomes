package com.devedu.CadrastoDeNomes.Repositorys


import android.content.Context
import androidx.lifecycle.LiveData
import com.devedu.CadrastoDeNomes.Room.dao.NomesEntity
import com.devedu.CadrastoDeNomes.Room.dao.NomesDataBase

class GuestRepository(context: Context) {

    // Acesso ao banco de dados

    private val mDataBase = NomesDataBase.getDatabase(context).nomesDAO()

    fun mInsert(nome: NomesEntity): Boolean {
        return mDataBase.insert(nome) > 0
    }

    fun mUpdate(guest: NomesEntity) {
        return mDataBase.update(guest)
    }

    fun mDelete(id:Int) {
        mDataBase.delete(id)
    }


    fun mGetAll():LiveData<List<NomesEntity>>{
        return mDataBase.getAll()
    }

}

