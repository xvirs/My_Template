package com.project.mytemplate.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductRequestBody(
    val count: Int,
    val start: Int,
    val query: String
)