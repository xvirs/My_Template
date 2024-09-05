package com.project.mytemplate.presentation.navegation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.mytemplate.presentation.components.scaffold.Scaffold
import com.project.mytemplate.presentation.screens.login.Login

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "login"
    ){

        composable("login") {
            Login(navController)
        }
        composable("main") {
            Scaffold()
        }
    }
}