package com.project.mytemplate.data.datasource

import com.project.mytemplate.data.interfaces.LoginDataSource
import com.project.mytemplate.data.models.LoginRequest
import com.project.mytemplate.data.models.dto.LoginResponseDto
import com.project.mytemplate.data.network.BaseClient
import com.project.mytemplate.utils.StatusResult
import io.ktor.client.call.body
import io.ktor.serialization.JsonConvertException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LoginDataSourceImpl : LoginDataSource {

    override suspend fun login(loginRequest: LoginRequest): StatusResult<LoginResponseDto> {
        return when (val response: StatusResult<LoginResponseDto> =
            fetchLogin("/customer/login", "error al hacer login", loginRequest)) {
            is StatusResult.Success -> response
            is StatusResult.Error -> response
        }
    }

    private suspend inline fun <reified T : Any> fetchLogin(
        url: String,
        errorMessage: String,
        loginRequest: LoginRequest
    ): StatusResult<T> {

        val json = Json.encodeToString(loginRequest)
        val httpResult = BaseClient.baseClient.post(
            endpoint = url,
            body = json,
            errorMessage = errorMessage
        )
        try {
            httpResult.httpResponse?.let {
                return StatusResult.Success(value = it.body())
            }
            return StatusResult.Error(httpResult.errorMessage)
        } catch (e: JsonConvertException) {
            return StatusResult.Error(e.message.toString())
        }
    }
}