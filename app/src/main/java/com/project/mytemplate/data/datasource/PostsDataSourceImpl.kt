package com.project.mytemplate.data.datasource

import com.project.mytemplate.data.interfaces.PostsDataSource
import com.project.mytemplate.data.models.dto.PostDto
import com.project.mytemplate.data.network.BaseClient
import com.project.mytemplate.utils.StatusResult
import io.ktor.client.call.body

class PostsDataSourceImpl : PostsDataSource {

    override suspend fun fetchPosts(): StatusResult<List<PostDto>> {
        val response = BaseClient.baseClient.get(
            "http://jsonplaceholder.typicode.com/posts",
            "Error al obtener datos"
        )
        try {
            response.httpResponse.let {
                if (it != null) {
                    return StatusResult.Success(it.body())
                } else {
                    return StatusResult.Error("Lista vacia")
                }
            }
        } catch (e: Exception) {
            return StatusResult.Error(e.message.toString())
        }
    }
}