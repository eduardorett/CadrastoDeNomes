package com.devedu.CadrastoDeNomes.Room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NomesEntity::class],version=1)
abstract class NomesDataBase:RoomDatabase(){

    abstract fun nomesDAO(): NomesDAO

    companion object {
        private lateinit var INSTANCE: NomesDataBase

        fun getDatabase(context: Context): NomesDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(NomesDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, NomesDataBase::class.java, "tabeladenomesDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

    }
}