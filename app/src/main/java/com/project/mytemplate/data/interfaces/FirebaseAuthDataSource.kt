package com.project.mytemplate.data.interfaces

import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthDataSource {
    suspend fun signInWithEmail(email: String, password: String): Result<FirebaseUser>
    suspend fun signUpWithEmail(email: String, password: String): Result<FirebaseUser>
    suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser>
    fun getCurrentUser(): FirebaseUser?
    fun signOut()
}
