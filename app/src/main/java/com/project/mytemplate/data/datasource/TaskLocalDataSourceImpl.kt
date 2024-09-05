package com.project.mytemplate.data.datasource

import com.project.mytemplate.data.interfaces.dao.TaskDao
import com.project.mytemplate.data.models.entity.TaskEntity
import com.project.mytemplate.data.interfaces.TaskLocalDataSource


class TaskLocalDataSourceImpl(private val taskDao: TaskDao) : TaskLocalDataSource {

    override suspend fun getTasks(): List<TaskEntity> = taskDao.getTasks()
    override suspend fun insertTask(taskEntity: TaskEntity) = taskDao.insertTask(taskEntity)
    override suspend fun deleteTask(taskEntity: TaskEntity) = taskDao.deleteTask(taskEntity.id)
    override suspend fun updateTask(taskEntity: TaskEntity) = taskDao.updateTask(
        taskEntity.id,
        taskEntity.title,
        taskEntity.description,
        taskEntity.state,
    )
}

