package com.project.mytemplate.presentation.components.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(
    onLoginClick: (email: String, password: String) -> Unit,
    onGoogleSignInClick: () -> Unit,
    onSignUpClick: (email: String, password: String) -> Unit,
    isError: Boolean? = null
) {
    var email by remember { mutableStateOf("pepito@gmail.com") }
    var password by remember { mutableStateOf("1234567890") }
    val error by remember { mutableStateOf(isError ?: false) }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text( "Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = error
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = error
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onLoginClick(email, password) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onGoogleSignInClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login with Google")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            onClick = {onSignUpClick(email, password)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }
    }
}
