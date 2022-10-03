package com.oy.taipeizoo.repository

import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.network.RetroService
import com.oy.taipeizoo.network.mappers.AnimalLocationDtoMapper

class AnimalLocationRepositoryImpl(
    private val retroService: RetroService,
    private val mapper: AnimalLocationDtoMapper
):AnimalLocationRepository {
    override suspend fun get(): List<AnimalLocationInfo> {
        return mapper.toDomainList(retroService.getLocation().result.locations)
    }
}