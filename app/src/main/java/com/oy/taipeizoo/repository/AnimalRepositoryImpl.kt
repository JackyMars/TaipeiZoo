package com.oy.taipeizoo.repository

import com.oy.taipeizoo.database.mappers.AnimalEntityMapper
import com.oy.taipeizoo.database.model.AnimalDao
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.network.RetroService
import com.oy.taipeizoo.network.mappers.AnimalDtoMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimalRepositoryImpl
    @Inject
    constructor(
    private val retroService: RetroService,
    private val animalDao: AnimalDao,
    private val mapperDto: AnimalDtoMapper,
    private val mapperDao: AnimalEntityMapper
):AnimalRepository {
    override suspend fun serach(query: String, offset: Int, limit: Int): List<AnimalInfo> {
        return mapperDto.toDomainList(retroService.search(query,offset,limit).result.animals)
    }

    override suspend fun insertAnimal(animal: AnimalInfo):Long {
        return animalDao.insertAnimal(mapperDao.mapToDomainModel(animal))
    }

    override suspend fun insertAnimals(animals: List<AnimalInfo>):LongArray {
        return animalDao.insertAnimals(mapperDao.fromDomainList(animals))
    }

    override suspend fun readAnimals(): List<AnimalInfo> {
        return mapperDao.toDomainList(animalDao.readAnimals())
    }

    override suspend fun findAnimalsByLocation(location: String): List<AnimalInfo> {
        return mapperDao.toDomainList(animalDao.findAnimalsByLocation(location))
    }

    override suspend fun findAnimalById(id: Int): AnimalInfo {
        return mapperDao.mapFromDomainModel(animalDao.findAnimalById(id))
    }

    override suspend fun findAnimalByName(name: String): AnimalInfo {
        return mapperDao.mapFromDomainModel(animalDao.findAnimalByName(name))
    }

}