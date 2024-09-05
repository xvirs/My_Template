package com.project.mytemplate.presentation.components.screen1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.project.mytemplate.domine.models.Post

@Composable
fun ListPosts(posts : List<Post>){
    LazyColumn(
        modifier = Modifier
            .clip( shape = Shapes().large )
    ) {
        posts.map {
            item {
                Post(title = it.title, body = it.body)
            }
        }
    }
}

@Composable
fun Post(title: String, body: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = body)
        }
    }
}