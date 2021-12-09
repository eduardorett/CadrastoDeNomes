package com.devedu.cadrastodenomes.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="Tabeladenomes")
  class NomesEntity (

 @PrimaryKey(autoGenerate = true)
 @ColumnInfo(name="id")
  var id:Int = 0,
 @ColumnInfo(name="nome")
 var nome:String =""// o dele so tem o primarykey e o segundo val n é columinfo, deveria ser?
)