package com.project.mytemplate.data.repository


import com.project.mytemplate.data.interfaces.PostsDataSource
import com.project.mytemplate.domine.interfaces.PostsRepository
import com.project.mytemplate.domine.models.Post
import com.project.mytemplate.utils.StatusResult
import com.project.mytemplate.data.mappers.toPost

class PostsRepositoryImpl(
    private val postsDataSource: PostsDataSource,
) : PostsRepository {

    override suspend fun getPosts(): StatusResult<List<Post>> {
        return when (val result = postsDataSource.fetchPosts()) {
            is StatusResult.Success -> {
                StatusResult.Success(result.value.map { it.toPost() })
            }

            is StatusResult.Error -> {
                StatusResult.Error(result.message)
            }
        }
    }

}