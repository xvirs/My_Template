package com.project.mytemplate.presentation.components.scaffold

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(snackBarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = "My Template",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = {
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        message = "Home",
                        actionLabel = "Deshacer"
                    )
                }
            }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
    )
}