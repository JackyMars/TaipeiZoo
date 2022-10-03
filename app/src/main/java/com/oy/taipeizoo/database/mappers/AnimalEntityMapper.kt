package com.oy.taipeizoo.database.mappers

import com.oy.taipeizoo.database.model.AnimalEntity
import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.util.DomainMapper

class AnimalEntityMapper:DomainMapper<AnimalEntity,AnimalInfo> {
    override fun mapFromDomainModel(model: AnimalEntity): AnimalInfo {
        return AnimalInfo(
            id = model.apiId,
            name_ch = model.name_ch,
            location = model.location,
            distribution = model.distribution,
            a_phylum = model.a_phylum,
            a_class = model.a_class,
            a_order = model.a_order,
            a_family = model.a_family,
            feature = model.feature,
            behavior = model.behavior,
            diet = model.diet,
            url = model.url
        )
    }

    override fun mapToDomainModel(domainModel: AnimalInfo): AnimalEntity {
        return AnimalEntity(
            id = domainModel.id,
            apiId = domainModel.id,
            name_ch = domainModel.name_ch,
            location = domainModel.location,
            distribution = domainModel.distribution,
            a_phylum = domainModel.a_phylum,
            a_class = domainModel.a_class,
            a_order = domainModel.a_order,
            a_family = domainModel.a_family,
            feature = domainModel.feature,
            behavior = domainModel.behavior,
            diet = domainModel.diet,
            url = domainModel.url
        )
    }
    fun toDomainList(initial:List<AnimalEntity>):List<AnimalInfo>{
        return initial.map { mapFromDomainModel(it) }
    }

    fun fromDomainList(initial:List<AnimalInfo>):List<AnimalEntity>{
        return initial.map { mapToDomainModel(it) }
    }

}