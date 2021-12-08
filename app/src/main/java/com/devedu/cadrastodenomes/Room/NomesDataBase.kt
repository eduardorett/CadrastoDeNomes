package com.devedu.cadrastodenomes.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.devedu.cadrastodenomes.room.Dao.NomesDAO


@Database(entities = [NomesEntity::class],version=1)
abstract class NomesDataBase:RoomDatabase(){

    abstract fun nomesDAO(): NomesDAO

    companion object {
        private lateinit var INSTANCE: NomesDataBase

        fun getDatabase(context: Context): NomesDataBase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(NomesDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, NomesDataBase::class.java, "tabeladenomesDB")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        /**
         * Atualização de versão de banco de dados
         */
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }
        }

    }
}