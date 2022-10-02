package com.oy.taipeizoo.di

import com.oy.taipeizoo.network.RetroService
import com.oy.taipeizoo.network.model.AnimalDtoMapper
import com.oy.taipeizoo.network.model.AnimalLocationDtoMapper
import com.oy.taipeizoo.repository.AnimalLocationRepository
import com.oy.taipeizoo.repository.AnimalLocationRepositoryImpl
import com.oy.taipeizoo.repository.AnimalRepository
import com.oy.taipeizoo.repository.AnimalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAnimalRepositioy(
        retroService: RetroService,
        animalDtoMapper: AnimalDtoMapper
    ): AnimalRepository {
        return AnimalRepositoryImpl(
            retroService = retroService,
            mapper = animalDtoMapper
        )
    }
    @Singleton
    @Provides
    fun provideAnimalLocationRepository(
        retroService: RetroService,
        animalLocationDtoMapper: AnimalLocationDtoMapper
    ):AnimalLocationRepository{
        return AnimalLocationRepositoryImpl(
            retroService = retroService,
            mapper = animalLocationDtoMapper
        )
    }
}