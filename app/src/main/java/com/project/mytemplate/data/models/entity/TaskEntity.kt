package com.project.mytemplate.data.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TaskEntity")
data class TaskEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val state: String
)


