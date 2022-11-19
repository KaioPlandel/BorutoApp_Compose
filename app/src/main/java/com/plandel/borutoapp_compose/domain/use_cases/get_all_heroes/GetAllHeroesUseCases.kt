package com.plandel.borutoapp_compose.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.plandel.borutoapp_compose.data.repository.Repository
import com.plandel.borutoapp_compose.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCases(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}