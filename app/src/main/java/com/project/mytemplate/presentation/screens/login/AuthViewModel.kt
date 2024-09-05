package com.project.mytemplate.presentation.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.project.mytemplate.domine.usecase.firebase.SignInWithEmailUseCase
import com.project.mytemplate.domine.usecase.firebase.SignInWithGoogleUseCase
import com.project.mytemplate.domine.usecase.firebase.SignUpWithEmailUseCase
import kotlinx.coroutines.launch

class AuthViewModel(
    private val signInWithEmailUseCase: SignInWithEmailUseCase,
    private val signUpWithEmailUseCase: SignUpWithEmailUseCase,
    private val signInWithGoogleUseCase: SignInWithGoogleUseCase
) : ViewModel() {
    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    fun signInWithEmail(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = signInWithEmailUseCase.invoke(email, password)
            _authState.value = if (result.isSuccess){
                AuthState.Authenticated(result.getOrNull()!!)
            } else {
                AuthState.Error(result.exceptionOrNull())
            }
        }
    }

    fun signUpWithEmail(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = signUpWithEmailUseCase.invoke(email, password)
            _authState.value = if (result.isSuccess) AuthState.Authenticated(result.getOrNull()!!) else AuthState.Error(result.exceptionOrNull())
        }
    }

    fun signInWithGoogle(idToken: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            val result = signInWithGoogleUseCase.invoke(idToken)
            _authState.value = if (result.isSuccess) AuthState.Authenticated(result.getOrNull()!!) else AuthState.Error(result.exceptionOrNull())
        }
    }

}

sealed class AuthState {
    object Loading : AuthState()
    data class Authenticated(val user: FirebaseUser) : AuthState()
    data class Error(val error: Throwable?) : AuthState()
    object Unauthenticated : AuthState()
}