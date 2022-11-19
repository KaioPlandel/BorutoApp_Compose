package com.plandel.borutoapp_compose.domain.repository

import androidx.paging.PagingData
import com.plandel.borutoapp_compose.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(): Flow<PagingData<Hero>>
}