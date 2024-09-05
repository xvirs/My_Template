package com.project.mytemplate.domine.interfaces

import com.project.mytemplate.domine.models.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
    suspend fun addTask(task: Task)
    suspend fun removeTask(task: Task)
    suspend fun updateTask(task: Task)
}