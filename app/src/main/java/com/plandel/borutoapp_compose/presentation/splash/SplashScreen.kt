package com.plandel.borutoapp_compose.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.plandel.borutoapp_compose.R
import com.plandel.borutoapp_compose.ui.theme.Purple500
import com.plandel.borutoapp_compose.ui.theme.Purple700

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
}

@Composable
fun Splash() {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Purple700,
                            Purple500
                        )
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    }
}