package com.project.mytemplate.data.repository

import com.google.firebase.auth.FirebaseUser
import com.project.mytemplate.data.interfaces.FirebaseAuthDataSource
import com.project.mytemplate.domine.interfaces.FirebaseAuthRepository

class FirebaseFirebaseAuthRepositoryImpl(
    private val firebaseAuthDataSource: FirebaseAuthDataSource
) : FirebaseAuthRepository {

    override suspend fun signInWithEmail(email: String, password: String): Result<FirebaseUser> {
        return firebaseAuthDataSource.signInWithEmail(email, password)
    }

    override suspend fun signUpWithEmail(email: String, password: String): Result<FirebaseUser> {
        return firebaseAuthDataSource.signUpWithEmail(email, password)
    }

    override suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser> {
        return firebaseAuthDataSource.signInWithGoogle(idToken)
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuthDataSource.getCurrentUser()
    }

    override fun signOut() {
        firebaseAuthDataSource.signOut()
    }
}
