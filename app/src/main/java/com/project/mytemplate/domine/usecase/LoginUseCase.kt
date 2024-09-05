package com.project.mytemplate.domine.usecase

import com.project.mytemplate.data.models.LoginRequest
import com.project.mytemplate.domine.interfaces.LoginRepository
import com.project.mytemplate.domine.models.LoginResponse
import com.project.mytemplate.utils.StatusResult

class LoginUseCase(private val loginRepository: LoginRepository) {
    suspend fun login(loginRequest : LoginRequest): StatusResult<LoginResponse> {
        return when (val result = loginRepository.login(loginRequest)) {
            is StatusResult.Error -> StatusResult.Error(result.message)
            is StatusResult.Success -> StatusResult.Success(result.value)
        }
    }
}