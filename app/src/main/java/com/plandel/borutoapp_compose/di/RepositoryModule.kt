package com.plandel.borutoapp_compose.di

import android.content.Context
import com.plandel.borutoapp_compose.data.repository.DataStoreOperationsImpl
import com.plandel.borutoapp_compose.data.repository.Repository
import com.plandel.borutoapp_compose.domain.repository.DataStoreOperations
import com.plandel.borutoapp_compose.domain.use_cases.UseCases
import com.plandel.borutoapp_compose.domain.use_cases.get_all_heroes.GetAllHeroesUseCases
import com.plandel.borutoapp_compose.domain.use_cases.readonboarding.ReadOnBoardingUseCase
import com.plandel.borutoapp_compose.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCases = GetAllHeroesUseCases(repository)
        )
    }

}