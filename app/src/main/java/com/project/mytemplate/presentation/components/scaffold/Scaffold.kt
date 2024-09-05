package com.project.mytemplate.presentation.components.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.mytemplate.presentation.navegation.Screen
import com.project.mytemplate.presentation.screens.screen1.ScreenOne
import com.project.mytemplate.presentation.screens.screen2.ScreenTwo
import com.project.mytemplate.presentation.screens.screen3.ScreenThree

@Composable
fun Scaffold() {
    val navController = rememberNavController()
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(
                snackBarHostState = snackBarHostState,
                coroutineScope = coroutineScope
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        content = { innerPadding ->
            NavHost(
                navController,
                startDestination = Screen.Screen1.route,
                Modifier.padding(innerPadding)
            ) {
                composable(Screen.Screen1.route) { ScreenOne() }
                composable(Screen.Screen2.route) { ScreenTwo() }
                composable(Screen.Screen3.route) { ScreenThree(
                    snackBarHostState = snackBarHostState,
                    coroutineScope = coroutineScope
                ) }
            }

        }
    )
}

