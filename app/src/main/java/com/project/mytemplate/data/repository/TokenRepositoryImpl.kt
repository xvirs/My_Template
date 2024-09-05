package com.project.mytemplate.data.repository

import com.project.mytemplate.data.datasource.TokenDataSourceImpl
import kotlinx.coroutines.flow.Flow

class TokenRepositoryImpl(private val tokenDataStore: TokenDataSourceImpl) {

    val token: Flow<String?> = tokenDataStore.token

    suspend fun saveToken(token: String) {
        tokenDataStore.saveToken(token)
    }

    suspend fun clearToken() {
        tokenDataStore.clearToken()
    }

}