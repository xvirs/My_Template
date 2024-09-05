package com.project.mytemplate.domine.interfaces

import com.project.mytemplate.domine.models.Post
import com.project.mytemplate.utils.StatusResult

interface PostsRepository {
    suspend fun getPosts(): StatusResult<List<Post>>

//    suspend fun addPost(post: Post)

}