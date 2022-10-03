package com.oy.taipeizoo.database.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.oy.taipeizoo.database.model.AnimalLocationEntity

@Dao
interface AnimalLocationDao {

    @Insert
    suspend fun insertLocation(location: AnimalLocationEntity)

    @Insert
    suspend fun insertLocations(locations:List<AnimalLocationEntity>)

    @Query("SELECT * FROM animal_locations ORDER BY apiId ASC")
    suspend fun readLocations(): List<AnimalLocationEntity>
}