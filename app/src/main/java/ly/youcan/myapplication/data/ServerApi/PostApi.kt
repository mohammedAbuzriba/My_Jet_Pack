package ly.youcan.myapplication.data.ServerApi

import ly.youcan.myapplication.data.ServerApi.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getAllpost():Response<Post>
}