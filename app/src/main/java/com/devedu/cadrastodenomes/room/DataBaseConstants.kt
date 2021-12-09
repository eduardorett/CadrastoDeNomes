package com.devedu.cadrastodenomes.room

class DataBaseConstants private constructor() {

    /**
     * Tabelas disponíveis no banco de dados com suas colunas
     */
    object GUEST {
        const val TABLE_NAME = "Tabeladenomes"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
        }
    }
}