package com.devedu.cadrastodenomes.repositorys


import android.content.Context
import androidx.lifecycle.LiveData
import com.devedu.cadrastodenomes.room.dao.NomesEntity
import com.devedu.cadrastodenomes.room.dao.NomesDataBase

class NomesRepository(context: Context) {

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


    fun mGetAll(): List<NomesEntity>{
        return mDataBase.getAll()
    }

}

