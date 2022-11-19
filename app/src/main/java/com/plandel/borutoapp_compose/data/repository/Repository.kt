package com.plandel.borutoapp_compose.data.repository

import androidx.paging.PagingData
import com.plandel.borutoapp_compose.domain.model.Hero
import com.plandel.borutoapp_compose.domain.repository.DataStoreOperations
import com.plandel.borutoapp_compose.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun saveOnBoardingState(completed: Boolean) {
        dataStore.readOnBoardingState()
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}