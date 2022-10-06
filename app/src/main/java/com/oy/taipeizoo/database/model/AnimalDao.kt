package com.oy.taipeizoo.database.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oy.taipeizoo.database.model.AnimalEntity

@Dao
interface AnimalDao {
    /**
     * onConflict = OnConflictStrategy.REPLACE
     * 表示新增物件時和舊物件發生衝突後的處置
     * REPLACE 蓋掉 (最常用)
     * ROLLBACK 閃退
     * ABORT 閃退 (默認)
     * FAIL 閃退
     * IGNORE 忽略，還是舊的資料
     * https://developer.android.com/reference/android/arch/persistence/room/OnConflictStrategy
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimal(animal: AnimalEntity):Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimals(animals:List<AnimalEntity>):LongArray

    @Query("SELECT * FROM animals ORDER BY apiId ASC")
    suspend fun readAnimals():List<AnimalEntity>

    @Query("SELECT * FROM animals WHERE location LIKE '%' || :location || '%'")
    suspend fun findAnimalsByLocation(location:String):List<AnimalEntity>

    @Query("SELECT * FROM animals WHERE apiId = :id")
    suspend fun findAnimalById(id:Int):AnimalEntity

    @Query("SELECT * FROM animals WHERE name_ch LIKE '%' || :name || '%'")
    suspend fun findAnimalByName(name:String):List<AnimalEntity>

}