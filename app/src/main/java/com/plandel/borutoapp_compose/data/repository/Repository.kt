package com.plandel.borutoapp_compose.data.repository

import com.plandel.borutoapp_compose.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {
    fun saveOnBoardingState(completed: Boolean) {
        dataStore.readOnBoardingState()
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}