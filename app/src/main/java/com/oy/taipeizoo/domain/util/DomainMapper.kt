package com.oy.taipeizoo.domain.util

interface DomainMapper <T,DomainModel>{

    fun mapFromDomainModel(model: T):DomainModel

    fun mapToDomainModel(domainModel: DomainModel):T

}