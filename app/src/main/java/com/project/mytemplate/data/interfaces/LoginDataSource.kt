package com.project.mytemplate.data.interfaces

import com.project.mytemplate.data.models.LoginRequest
import com.project.mytemplate.data.models.dto.LoginResponseDto
import com.project.mytemplate.utils.StatusResult

interface LoginDataSource {
    suspend fun login(loginRequest: LoginRequest): StatusResult<LoginResponseDto>
}