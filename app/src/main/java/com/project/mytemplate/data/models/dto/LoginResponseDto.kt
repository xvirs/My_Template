package com.project.mytemplate.data.models.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val id: Int,
    val token: String
)
