package com.plandel.borutoapp_compose.presentation.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.plandel.borutoapp_compose.R
import com.plandel.borutoapp_compose.ui.theme.topAppBarBackgroundColor
import com.plandel.borutoapp_compose.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(onSearchClick: () -> Unit){
    TopAppBar(
        title = {
            Text(text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = { onSearchClick }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            }
        }
    )
}