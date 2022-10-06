package com.oy.taipeizoo.repository

import com.oy.taipeizoo.database.model.AnimalEntity
import com.oy.taipeizoo.domain.model.AnimalInfo


interface AnimalRepository {

    suspend fun serach(query:String,offset:Int,limit:Int):List<AnimalInfo>

    suspend fun insertAnimal(animal:AnimalInfo):Long

    suspend fun insertAnimals(animals: List<AnimalInfo>): LongArray

    suspend fun readAnimals():List<AnimalInfo>

    suspend fun findAnimalsByLocation(location:String):List<AnimalInfo>

    suspend fun findAnimalById(id:Int): AnimalInfo

    suspend fun findAnimalByName(name:String):List<AnimalInfo>
}