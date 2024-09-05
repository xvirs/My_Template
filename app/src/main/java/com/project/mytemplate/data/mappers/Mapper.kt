package com.project.mytemplate.data.mappers

//import com.project.mytemplate.data.datasource.room.PostEntity
import com.project.mytemplate.data.models.dto.LoginResponseDto
import com.project.mytemplate.data.models.dto.PostDto
import com.project.mytemplate.domine.models.ImageModel
import com.project.mytemplate.domine.models.LoginResponse
import com.project.mytemplate.domine.models.Post
import com.project.mytemplate.domine.models.ProductModel
import com.project.mytemplate.domine.models.ProductsResponseModel

fun PostDto.toPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}

fun LoginResponseDto.toLogin(): LoginResponse {
    return LoginResponse(
        id = id,
        token = token
    )
}




//fun Post.toPostEntity(): PostEntity {
//    return PostEntity(
//        id = id,
//        userId = userId,
//        title = title,
//        body = body
//    )
//}



