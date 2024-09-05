package com.project.mytemplate.domine.usecase

import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.models.Task

class ChangeTaskStateUseCase(private val taskRepository: TaskRepository) {

    suspend operator fun invoke(task: Task) {
        val updatedTask = task.copy(state = !task.state)
        taskRepository.updateTask(updatedTask)
    }
}
