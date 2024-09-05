package com.project.mytemplate.domine.usecase

import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.models.Task

class RemoveTaskUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        taskRepository.removeTask(task)
    }
}
