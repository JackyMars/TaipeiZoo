package com.oy.taipeizoo.di

import android.app.Application
import androidx.room.Room
import com.oy.taipeizoo.database.AnimalDatabase
import com.oy.taipeizoo.database.mappers.AnimalEntityMapper
import com.oy.taipeizoo.database.mappers.AnimalLocationEntityMapper
import com.oy.taipeizoo.database.model.AnimalDao
import com.oy.taipeizoo.database.model.AnimalLocationDao
import com.oy.taipeizoo.network.mappers.AnimalDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDb(app: Application): AnimalDatabase {
        return Room
            .databaseBuilder(app, AnimalDatabase::class.java, AnimalDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @Singleton
    @Provides
    fun provideAnimalDao(db: AnimalDatabase): AnimalDao {
        return db.getAnimalDao()
    }

    @Singleton
    @Provides
    fun provideAnimalLocationDao(db: AnimalDatabase): AnimalLocationDao {
        return db.getAnimalLocationDao()
    }

    @Singleton
    @Provides
    fun provideAnimalDaoMapper():AnimalEntityMapper{
        return AnimalEntityMapper()
    }

    @Singleton
    @Provides
    fun provideAnimalLocationDaoMapper():AnimalLocationEntityMapper{
        return AnimalLocationEntityMapper()
    }
}