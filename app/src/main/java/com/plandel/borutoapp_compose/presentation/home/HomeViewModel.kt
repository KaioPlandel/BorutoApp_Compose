package com.plandel.borutoapp_compose.presentation.home

import androidx.lifecycle.ViewModel
import com.plandel.borutoapp_compose.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCases()
}