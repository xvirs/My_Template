package com.project.mytemplate.data.interfaces

import com.project.mytemplate.data.models.dto.PostDto
import com.project.mytemplate.utils.StatusResult

interface PostsDataSource {
    suspend fun fetchPosts(): StatusResult<List<PostDto>>
}