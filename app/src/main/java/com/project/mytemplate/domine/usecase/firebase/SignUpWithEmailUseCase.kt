package com.project.mytemplate.domine.usecase.firebase

import com.google.firebase.auth.FirebaseUser
import com.project.mytemplate.domine.interfaces.FirebaseAuthRepository

class SignUpWithEmailUseCase(private val repository: FirebaseAuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<FirebaseUser> {
        return repository.signUpWithEmail(email, password)
    }
}
