package com.oy.taipeizoo.repository

import com.oy.taipeizoo.domain.model.AnimalInfo


interface AnimalRepository {

    suspend fun serach(query:String,offset:Int,limit:Int):List<AnimalInfo>

    suspend fun insertAnimal(animal:AnimalInfo):Long

    suspend fun insertAnimals(animals: List<AnimalInfo>): LongArray

    fun readAnimals():List<AnimalInfo>

    fun findAnimalsByLocation(location:String):List<AnimalInfo>
}