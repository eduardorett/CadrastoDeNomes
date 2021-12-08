package com.devedu.cadrastodenomes.Repositorys


import android.content.Context
import com.devedu.cadrastodenomes.Room.NomesEntity
import com.devedu.cadrastodenomes.Room.NomesDataBase

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

