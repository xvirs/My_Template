package com.project.mytemplate.domine.interfaces

import com.project.mytemplate.data.models.LoginRequest
import com.project.mytemplate.domine.models.LoginResponse
import com.project.mytemplate.utils.StatusResult

interface LoginRepository {
    suspend fun login(loginRequest : LoginRequest) : StatusResult<LoginResponse>
}