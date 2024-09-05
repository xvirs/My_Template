package com.project.mytemplate.domine.usecase.firebase

import com.google.firebase.auth.FirebaseUser
import com.project.mytemplate.domine.interfaces.FirebaseAuthRepository

class SignInWithEmailUseCase(private val repository: FirebaseAuthRepository) {
    suspend fun invoke(email: String, password: String): Result<FirebaseUser> {
        return repository.signInWithEmail(email, password)
    }
}
