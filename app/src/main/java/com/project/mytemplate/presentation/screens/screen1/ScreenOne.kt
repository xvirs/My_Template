package com.project.mytemplate.presentation.screens.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import com.project.mytemplate.presentation.components.screen1.ListPosts
import com.project.mytemplate.presentation.components.utils.Loading
import org.koin.androidx.compose.koinViewModel


@Composable
fun ScreenOne(viewModel: ScreenOneViewModel = koinViewModel()) {
    val title = viewModel.title.collectAsState()
    val body = viewModel.body.collectAsState()
    val posts = viewModel.posts.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    if (isLoading.value){
        Loading()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Button(onClick = { viewModel.fetchPosts() }) {
                Text(text = "LLamar Datos")
            }
            ListPosts(posts = posts.value)
        }
    }

}

