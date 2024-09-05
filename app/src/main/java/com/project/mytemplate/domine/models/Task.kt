package com.project.mytemplate.domine.models

data class Task (
    val id: Int? = System.currentTimeMillis().hashCode(),
    val title: String,
    val description: String,
    var state: Boolean
)
