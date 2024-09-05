package com.project.mytemplate.data.interfaces

import com.project.mytemplate.data.models.entity.TaskEntity

interface TaskLocalDataSource {
    suspend fun getTasks(): List<TaskEntity>
    suspend fun insertTask(taskEntity: TaskEntity)
    suspend fun deleteTask(taskEntity: TaskEntity)
    suspend fun updateTask(taskEntity: TaskEntity)
}