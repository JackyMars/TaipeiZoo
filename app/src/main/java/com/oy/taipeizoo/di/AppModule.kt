package com.oy.taipeizoo.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.oy.taipeizoo.database.model.AnimalDao
import com.oy.taipeizoo.database.AnimalDatabase
import com.oy.taipeizoo.database.AnimalDatabase.Companion.DATABASE_NAME
import com.oy.taipeizoo.database.model.AnimalLocationDao
import com.oy.taipeizoo.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }


}