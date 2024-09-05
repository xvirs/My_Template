package com.project.mytemplate.domine.usecase

import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.models.Task

class GetTasksUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(): List<Task> {
        return taskRepository.getTasks()
    }
}
