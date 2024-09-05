package com.project.mytemplate.domine.usecase

import com.project.mytemplate.domine.interfaces.PostsRepository
import com.project.mytemplate.domine.models.Post
import com.project.mytemplate.utils.StatusResult

class GetPostsUseCase(private val postsRepository: PostsRepository) {

    suspend fun invoke(): StatusResult<List<Post>> {
        return postsRepository.getPosts()
    }

}