package com.plandel.borutoapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.plandel.borutoapp_compose.navigation.NavGraph
import com.plandel.borutoapp_compose.ui.theme.BorutoApp_ComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoApp_ComposeTheme {
                var navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
