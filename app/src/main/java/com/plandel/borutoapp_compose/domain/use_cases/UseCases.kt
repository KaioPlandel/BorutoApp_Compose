package com.plandel.borutoapp_compose.domain.use_cases

import com.plandel.borutoapp_compose.domain.use_cases.get_all_heroes.GetAllHeroesUseCases
import com.plandel.borutoapp_compose.domain.use_cases.readonboarding.ReadOnBoardingUseCase
import com.plandel.borutoapp_compose.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCases: GetAllHeroesUseCases
)