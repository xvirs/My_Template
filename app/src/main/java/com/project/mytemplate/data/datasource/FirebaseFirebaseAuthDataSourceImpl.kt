package com.project.mytemplate.data.datasource

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.project.mytemplate.data.interfaces.FirebaseAuthDataSource
import kotlinx.coroutines.tasks.await

class FirebaseFirebaseAuthDataSourceImpl : FirebaseAuthDataSource {

    companion object {
        val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    }

    override suspend fun signInWithEmail(email: String, password: String): Result<FirebaseUser> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(authResult.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUpWithEmail(email: String, password: String): Result<FirebaseUser> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.success(authResult.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signInWithGoogle(idToken: String): Result<FirebaseUser> {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        return try {
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            Result.success(authResult.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }
}
