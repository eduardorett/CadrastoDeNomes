package com.devedu.cadrastodenomes.room.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devedu.cadrastodenomes.room.NomesEntity

@Dao
interface NomesDAO {
    @Insert
    fun insert(tabeladenomes: NomesEntity): Long

    @Update
    fun update(tabeladenomes: NomesEntity)

    @Query("DELETE FROM tabeladenomes WHERE id =:id")
    fun delete(id: Int)

    @Query("SELECT * FROM tabeladenomes")
    fun getAll(): List<NomesEntity>
}
