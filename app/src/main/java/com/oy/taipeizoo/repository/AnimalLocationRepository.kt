package com.oy.taipeizoo.repository

import com.oy.taipeizoo.domain.model.AnimalLocationInfo

interface AnimalLocationRepository {
    suspend fun get():List<AnimalLocationInfo>
}