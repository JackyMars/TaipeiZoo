package com.oy.taipeizoo.di

import com.oy.taipeizoo.network.RetroService
import com.oy.taipeizoo.network.model.AnimalDtoMapper
import com.oy.taipeizoo.network.model.AnimalLocationDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

private const val BASE_URL="https://data.taipei/api/v1/dataset/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAmimalMapper(): AnimalDtoMapper {
        return AnimalDtoMapper()
    }

    @Singleton
    @Provides
    fun provideAnimalLocationMapper():AnimalLocationDtoMapper{
        return AnimalLocationDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRroService(): RetroService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroService::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideToken():String{
        return "qqedsdsadadasdadadasd"
    }
}