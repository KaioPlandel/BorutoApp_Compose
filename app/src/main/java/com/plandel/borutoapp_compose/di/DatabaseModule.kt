package com.plandel.borutoapp_compose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plandel.borutoapp_compose.data.local.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): RoomDatabase {
        return Room.databaseBuilder(
            context,
            HeroDatabase::class.java,
            "hero_database",
        ).build()
    }
}