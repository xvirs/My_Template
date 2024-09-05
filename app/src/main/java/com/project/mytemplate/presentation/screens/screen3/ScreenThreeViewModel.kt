package com.project.mytemplate.presentation.screens.screen3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.models.Task
import com.project.mytemplate.domine.usecase.AddTaskUseCase
import com.project.mytemplate.domine.usecase.ChangeTaskStateUseCase
import com.project.mytemplate.domine.usecase.GetTasksUseCase
import com.project.mytemplate.domine.usecase.RemoveTaskUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ScreenThreeViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val removeTaskUseCase: RemoveTaskUseCase,
    private val changeTaskStateUseCase: ChangeTaskStateUseCase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList: StateFlow<List<Task>> = _taskList

    init {
        loadTasks()
    }

    private fun loadTasks() {
        viewModelScope.launch {
            setLoading(true)
            _taskList.value = getTasksUseCase()
            setLoading(false)
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase(task)
            _taskList.value = getTasksUseCase()
        }
    }

    fun changeState(task: Task) {
        viewModelScope.launch {
            changeTaskStateUseCase(task)
            _taskList.value = getTasksUseCase()
        }
    }

    fun removeTask(task: Task) {
        viewModelScope.launch {
            removeTaskUseCase(task)
            _taskList.value = getTasksUseCase()
        }
    }

    fun setLoading(value: Boolean) {
        _isLoading.value = value
    }
}