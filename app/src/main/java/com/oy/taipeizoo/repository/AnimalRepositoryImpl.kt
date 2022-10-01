package com.oy.taipeizoo.repository

import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.network.RetroService
import com.oy.taipeizoo.network.model.AnimalDtoMapper

class AnimalRepositoryImpl(
    private val retroService: RetroService,
    private val mapper: AnimalDtoMapper
):AnimalRepository {
    override suspend fun serach(query: String, offset: Int, limit: Int): List<AnimalInfo> {
        return mapper.toDomainList(retroService.search(query,offset,limit).result.animals)
    }

}