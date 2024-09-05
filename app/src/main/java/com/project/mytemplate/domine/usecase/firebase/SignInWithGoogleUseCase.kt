package com.project.mytemplate.domine.usecase.firebase

import com.google.firebase.auth.FirebaseUser
import com.project.mytemplate.domine.interfaces.FirebaseAuthRepository

class SignInWithGoogleUseCase(private val repository: FirebaseAuthRepository) {
    suspend fun invoke(idToken: String): Result<FirebaseUser> {
        return repository.signInWithGoogle(idToken)
    }
}
