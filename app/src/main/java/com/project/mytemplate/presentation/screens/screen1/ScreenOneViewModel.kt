package com.project.mytemplate.presentation.screens.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mytemplate.domine.models.Post
import com.project.mytemplate.domine.usecase.GetPostsUseCase
import com.project.mytemplate.utils.StatusResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScreenOneViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()

    private val _body = MutableStateFlow("")
    val body = _body.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun fetchPosts() {
        viewModelScope.launch {
            setLoading(true)
            when (val result = getPostsUseCase.invoke()) {
                is StatusResult.Success -> {
                    _posts.value = result.value
                    setLoading(false)
                }

                is StatusResult.Error -> {
                }
            }
        }
    }

    fun setLoading(value: Boolean){
        _isLoading.value = value
    }
}