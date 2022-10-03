package com.oy.taipeizoo.database.mappers

import com.oy.taipeizoo.database.model.AnimalLocationEntity
import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.domain.util.DomainMapper


class AnimalLocationEntityMapper:DomainMapper<AnimalLocationEntity,AnimalLocationInfo> {
    override fun mapFromDomainModel(model: AnimalLocationEntity): AnimalLocationInfo {
        return AnimalLocationInfo(
            id = model.apiId,
            no = model.no,
            name = model.name,
            category = model.category
        )
    }

    override fun mapToDomainModel(domainModel: AnimalLocationInfo): AnimalLocationEntity {
        return AnimalLocationEntity(
            id = domainModel.id,
            apiId = domainModel.id,
            no = domainModel.no,
            name = domainModel.name,
            category = domainModel.category
        )
    }

    fun toDomainList(initial:List<AnimalLocationEntity>):List<AnimalLocationInfo>{
        return initial.map { mapFromDomainModel(it) }
    }

    fun fromDomainList(initial:List<AnimalLocationInfo>):List<AnimalLocationEntity> {
        return initial.map { mapToDomainModel(it) }
    }
}