package priv.jb.homework.repository

import priv.jb.homework.api.Api
import priv.jb.homework.data.Videos
import retrofit2.Response
import javax.inject.Inject

class ApiRepository  @Inject constructor(var api: Api){
    suspend fun getAppQuizData(parameter:HashMap<String,String>): Response<Videos> {
        return api.getAppQuiz(parameter)
    }
}