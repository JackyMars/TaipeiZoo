package com.oy.taipeizoo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oy.taipeizoo.database.model.AnimalDao
import com.oy.taipeizoo.database.model.AnimalLocationEntity
import com.oy.taipeizoo.database.model.AnimalEntity
import com.oy.taipeizoo.database.model.AnimalLocationDao

@Database(entities = [
    AnimalEntity::class,
    AnimalLocationEntity::class],
    version = 1
)
abstract class AnimalDatabase:RoomDatabase() {

    abstract fun getAnimalDao(): AnimalDao
    abstract fun getAnimalLocationDao(): AnimalLocationDao

    companion object{
        val DATABASE_NAME:String = "animal_database"
//        @Volatile
//        private var INSTANCE:AnimalDatabase? = null
//
//        fun getDatabase(context: Context):AnimalDatabase{
//            val tempInstance = INSTANCE
//            if(tempInstance != null){
//                return tempInstance
//            }
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AnimalDatabase::class.java,
//                    "animal_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
    }







}