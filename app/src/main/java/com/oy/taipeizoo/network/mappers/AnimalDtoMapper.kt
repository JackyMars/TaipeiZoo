package com.oy.taipeizoo.network.mappers

import com.oy.taipeizoo.domain.model.AnimalInfo
import com.oy.taipeizoo.domain.util.DomainMapper
import com.oy.taipeizoo.network.model.AnimalDto

class AnimalDtoMapper: DomainMapper<AnimalDto, AnimalInfo> {
    override fun mapFromDomainModel(model: AnimalDto): AnimalInfo {
        return AnimalInfo(
            id = model._id,
            name_ch = model.a_name_ch,
            location = model.a_location,
            distribution = model.a_distribution,
            a_phylum = model.a_phylum,
            a_class = model.a_class,
            a_order = model.a_order,
            a_family = model.a_family,
            feature = model.a_feature,
            behavior = model.a_behavior,
            diet = model.a_diet,
            url = model.a_pic01_url
        )
    }

    override fun mapToDomainModel(domainModel: AnimalInfo): AnimalDto {
        return AnimalDto(
            _id = domainModel.id,
            a_name_ch = domainModel.name_ch,
            a_location = domainModel.location,
            a_distribution = domainModel.distribution,
            a_phylum = domainModel.a_phylum,
            a_class = domainModel.a_class,
            a_order = domainModel.a_order,
            a_family = domainModel.a_family,
            a_feature = domainModel.feature,
            a_behavior = domainModel.behavior,
            a_diet = domainModel.diet,
            a_pic01_url = domainModel.url
        )
    }

    fun toDomainList(initial:List<AnimalDto>):List<AnimalInfo>{
        return initial.map { mapFromDomainModel(it) }
    }

    fun fromDomainList(initial:List<AnimalInfo>):List<AnimalDto>{
        return initial.map { mapToDomainModel(it) }
    }

}