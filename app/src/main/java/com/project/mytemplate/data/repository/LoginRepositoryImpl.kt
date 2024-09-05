package com.project.mytemplate.data.repository

import com.project.mytemplate.data.interfaces.LoginDataSource
import com.project.mytemplate.data.mappers.toLogin
import com.project.mytemplate.data.models.LoginRequest
import com.project.mytemplate.domine.interfaces.LoginRepository
import com.project.mytemplate.domine.models.LoginResponse
import com.project.mytemplate.utils.StatusResult

class LoginRepositoryImpl(private val loginDataSource: LoginDataSource) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): StatusResult<LoginResponse> {
        return when (val result = loginDataSource.login(loginRequest)) {
            is StatusResult.Success -> {
                StatusResult.Success(result.value.toLogin())
            }
            is StatusResult.Error -> {
                StatusResult.Error(result.message, result.errorType)
            }
        }
    }
}

