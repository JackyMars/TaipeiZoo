package com.oy.taipeizoo.repository

import com.oy.taipeizoo.domain.model.AnimalInfo

interface AnimalRepository {

    suspend fun serach(query:String,offset:Int,limit:Int):List<AnimalInfo>
}