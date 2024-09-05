package com.project.mytemplate.data.repository

import com.project.mytemplate.data.models.entity.TaskEntity
import com.project.mytemplate.data.interfaces.TaskLocalDataSource
import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.models.Task

class TaskRepositoryImpl(private val taskLocalDataSource: TaskLocalDataSource) : TaskRepository {
    override suspend fun getTasks(): List<Task> {
        return taskLocalDataSource.getTasks().map { taskEntity ->
            Task(taskEntity.id, taskEntity.title, taskEntity.description, taskEntity.state.toBoolean())
        }
    }

    override suspend fun addTask(task: Task) {
        val taskEntity = TaskEntity(task.id ?: 0, task.title, task.description, task.state.toString())
        taskLocalDataSource.insertTask(taskEntity)
    }

    override suspend fun removeTask(task: Task) {
        val taskEntity = TaskEntity(task.id ?: 0, task.title, task.description, task.state.toString())
        taskLocalDataSource.deleteTask(taskEntity)
    }

    override suspend fun updateTask(task: Task) {
        val taskEntity = TaskEntity(task.id ?: 0, task.title, task.description, task.state.toString())
        taskLocalDataSource.updateTask(taskEntity)
    }
}