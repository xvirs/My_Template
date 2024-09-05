package com.project.mytemplate.data.interfaces.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.mytemplate.data.models.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM TaskEntity")
    suspend fun getTasks(): List<TaskEntity>

    @Query("DELETE FROM TaskEntity WHERE id = :id")
    suspend fun deleteTask(id: Int)

    @Query("UPDATE TaskEntity SET title = :title, description = :description, state = :state WHERE id = :id")
    suspend fun updateTask(id: Int, title: String, description: String, state: String)
}