package com.plandel.borutoapp_compose.domain.use_cases.readonboarding

import com.plandel.borutoapp_compose.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}