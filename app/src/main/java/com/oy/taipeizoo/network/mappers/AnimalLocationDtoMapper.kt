package com.oy.taipeizoo.network.mappers

import com.oy.taipeizoo.domain.model.AnimalLocationInfo
import com.oy.taipeizoo.domain.util.DomainMapper
import com.oy.taipeizoo.network.model.AnimalLocationDto

class AnimalLocationDtoMapper:DomainMapper<AnimalLocationDto,AnimalLocationInfo> {
    override fun mapFromDomainModel(model: AnimalLocationDto): AnimalLocationInfo {
        return AnimalLocationInfo(
            id = model._id,
            no = model.e_no,
            name = model.e_name,
            category = model.e_category
        )
    }

    override fun mapToDomainModel(domainModel: AnimalLocationInfo): AnimalLocationDto {
        return AnimalLocationDto(
            _id = domainModel.id,
            e_no = domainModel.no,
            e_name = domainModel.name,
            e_category = domainModel.category
        )
    }
    fun toDomainList(initial:List<AnimalLocationDto>):List<AnimalLocationInfo>{
        return initial.map { mapFromDomainModel(it) }
    }

    fun fromDomainList(initial:List<AnimalLocationInfo>):List<AnimalLocationDto>{
        return initial.map { mapToDomainModel(it) }
    }
}