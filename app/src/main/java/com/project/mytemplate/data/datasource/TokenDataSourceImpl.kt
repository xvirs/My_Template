package com.project.mytemplate.data.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenDataSourceImpl(context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "auth_data_store")
    private val TOKEN_AUTH = stringPreferencesKey("auth_token")

    private val appContext = context.applicationContext

    val token: Flow<String?> = appContext.dataStore.data.map { preferences ->
        preferences[TOKEN_AUTH]
    }

    suspend fun saveToken(token: String) {
        appContext.dataStore.edit { preferences ->
            preferences[TOKEN_AUTH] = token
        }
    }

    suspend fun clearToken() {
        appContext.dataStore.edit { preferences ->
            preferences.remove(TOKEN_AUTH)
        }
    }
}