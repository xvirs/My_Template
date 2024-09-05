package com.project.mytemplate.presentation.screens.screen3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.project.mytemplate.domine.models.Task
import com.project.mytemplate.presentation.components.utils.Loading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun ScreenThree(
    viewModel: ScreenThreeViewModel = getViewModel(),
    snackBarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope
){

    var addNote by remember { mutableStateOf(false) }
    val taskList by viewModel.taskList.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    if(addNote){
        AddTask(
            saved = {
                viewModel.addTask(it)
                addNote = false
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        message = "Tarea Agregada",
                    )
                }
            },
            cancel = {
                addNote = false
                coroutineScope.launch {
                    snackBarHostState.showSnackbar(
                        message = "Tarea Descartada",
                    )
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center ){
        if (isLoading.value){
            Loading()
        } else {
            if(taskList.isNotEmpty()){
                ListTask(
                    listTask = taskList,
                    changeState = {
                        viewModel.changeState(it)
                    },
                    removeTask = {
                        viewModel.removeTask(it)
                    }
                )
            }else{
                Text(text = "Ingresa una Tarea")
            }
        }

        FloatingActionButton(
            onClick = {
                addNote = true
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription ="Add Note")
        }
    }

}

@Composable
fun ListTask(listTask : List<Task>, changeState: (Task) -> Unit, removeTask: (Task) -> Unit){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ){
        listTask.forEach { task ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Column(
                            modifier = Modifier
                                .weight(5f)
                                .padding(vertical = 4.dp)
                        ) {
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier
                                    .focusable(true)
                            )
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp, top = 6.dp)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.DeleteOutline,
                            contentDescription = "Delete Task",
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .clickable {
                                    removeTask(task)
                                }
                        )
                        Checkbox(
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp),
                            checked = task.state,
                            onCheckedChange = {
                                changeState(task)
                            }
                        )
                    }
                }
            }
        }
        item(){
            Spacer(modifier = Modifier.height(80.dp))
        }

    }

}

@Composable
fun AddTask(
    saved  : (Task) -> Unit,
    cancel : () -> Unit
){

    var titleTask by remember { mutableStateOf("") }
    var descriptionTask by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { cancel() },
    ) {
        Card(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleLarge,
                    text = "Ingresa una Tarea"
                )

                OutlinedTextField(
                    modifier = Modifier
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally),
                    value =titleTask,
                    onValueChange ={ titleTask = it },
                    label = { Text(text = "Titulo") },
                    minLines = 1,
                    shape = RoundedCornerShape(5.dp)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    value =descriptionTask,
                    onValueChange ={ descriptionTask = it },
                    label = { Text(text = "Descripcion") },
                    minLines = 5,
                    shape = RoundedCornerShape(10.dp)
                )

                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.End),
                    onClick = { saved(Task(title = titleTask, description =  descriptionTask, state = false)) }
                ) {
                    Text(text = "Cargar")
                }
            }
        }

    }

}