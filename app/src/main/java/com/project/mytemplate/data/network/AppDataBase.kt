package com.project.mytemplate.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.mytemplate.data.interfaces.dao.TaskDao
import com.project.mytemplate.data.models.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun taskDao(): TaskDao
}