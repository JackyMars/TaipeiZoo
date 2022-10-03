package com.oy.taipeizoo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_locations")
data class AnimalLocationEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "apiId")
    val apiId:Int,
    @ColumnInfo(name = "no")
    val no:Int,
    @ColumnInfo(name = "category")
    val category:String,
    @ColumnInfo(name = "name")
    val name:String
)