package com.devedu.martina.Room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NomesDAO {
    @Insert
    fun insert(tabeladenomes: NomesEntity):Long

    @Update
     fun update(tabeladenomes: NomesEntity)

    @Query("DELETE FROM tabeladenomes WHERE id =:id")
        fun delete(id:Int)

 @Query("SELECT * FROM tabeladenomes")
       fun getAll():LiveData<List<NomesEntity>> // se for livedata da ´pra fazer o observer atualizar soiznho
}
