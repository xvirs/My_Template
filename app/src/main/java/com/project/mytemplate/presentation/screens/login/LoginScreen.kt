package com.project.mytemplate.presentation.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.project.mytemplate.presentation.components.login.LoginScreen
import com.project.mytemplate.presentation.components.utils.Loading
import org.koin.androidx.compose.getViewModel

@Composable
fun Login(navController: NavHostController) {
    val viewModel: AuthViewModel = getViewModel()

    val authState by viewModel.authState.observeAsState()

    when (authState) {
        is AuthState.Loading -> Loading()
        is AuthState.Authenticated -> {
            navController.navigate("main")
        }
        is AuthState.Error -> LoginScreen(
            onLoginClick = { email, password -> viewModel.signInWithEmail(email, password) },
            onGoogleSignInClick = { /* Implementa lógica para iniciar sesión con Google */ },
            onSignUpClick = { email, password -> viewModel.signUpWithEmail(email, password) },
            isError = true
        )
        else -> LoginScreen(
            onLoginClick = { email, password -> viewModel.signInWithEmail(email, password) },
            onGoogleSignInClick = { /* Implementa lógica para iniciar sesión con Google */ },
            onSignUpClick = { email, password -> viewModel.signUpWithEmail(email, password) },
        )
    }

}

