package com.plandel.borutoapp_compose.domain.model

import androidx.annotation.DrawableRes
import com.plandel.borutoapp_compose.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explore",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
    object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
}
