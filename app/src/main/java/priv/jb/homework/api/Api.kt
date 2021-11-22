package priv.jb.homework.api

import priv.jb.homework.data.Videos
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @POST("appQuiz")
    suspend fun getAppQuiz(@Body parameter : Map<String,String>): Response<Videos>
}