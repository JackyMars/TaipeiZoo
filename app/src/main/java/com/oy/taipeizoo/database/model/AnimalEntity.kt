package com.oy.taipeizoo.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "animals")
data class AnimalEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "apiId")
    val apiId:Int,
    @ColumnInfo(name = "name_ch")
    val name_ch:String,
    @ColumnInfo(name = "location")
    val location:String,
    @ColumnInfo(name = "distribution")
    val distribution:String,
    @ColumnInfo(name = "a_phylum")
    val a_phylum:String,
    @ColumnInfo(name = "a_class")
    val a_class:String,
    @ColumnInfo(name = "a_order")
    val a_order:String,
    @ColumnInfo(name = "a_family")
    val a_family:String,
    @ColumnInfo(name = "feature")
    val feature:String,
    @ColumnInfo(name = "behavior")
    val behavior:String,
    @ColumnInfo(name = "diet")
    val diet:String,
    @ColumnInfo(name = "url")
    val url:String
)