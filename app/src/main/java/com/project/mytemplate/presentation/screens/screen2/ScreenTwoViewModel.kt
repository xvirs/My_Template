package com.project.mytemplate.presentation.screens.screen2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mytemplate.data.models.ProductRequestBody
import com.project.mytemplate.data.repository.TokenRepositoryImpl
import com.project.mytemplate.domine.models.ProductModel
import com.project.mytemplate.utils.StatusResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class ScreenTwoViewModel(
    authRepository: TokenRepositoryImpl,
) : ViewModel() {

    private val _tokenString = MutableStateFlow<String?>(null)
    val tokenString: Flow<String?> = _tokenString

    val token: Flow<String?> = authRepository.token

    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading

    private val _listProducts = MutableStateFlow<List<ProductModel>>(emptyList())
    val listProducts: Flow<List<ProductModel>> = _listProducts

    fun someAuthenticatedRequest() {
        viewModelScope.launch {
            val tokenValue = token.firstOrNull()
            if (tokenValue != null) {
                // Realiza la solicitud autenticada con el token
                _tokenString.value = tokenValue
            } else {
                // Maneja la falta de token
                _tokenString.value = "No hay token"
            }
        }
    }
    


    fun setLoading(value: Boolean){
        _isLoading.value = value
    }
}