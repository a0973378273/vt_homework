package priv.jb.homework.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.*
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import priv.jb.homework.repository.ApiRepository
import priv.jb.homework.data.Video
import priv.jb.homework.data.Videos
import javax.inject.Inject

@HiltViewModel
class AppQuizViewModel @Inject constructor(
    val repository : ApiRepository,
    val sharedPreferences: SharedPreferences,
    val gson: Gson
    ) : ViewModel(){

    val videosData : MutableLiveData<List<Video>> = MutableLiveData()
    val storageParameter = "listVideo"

    fun getQuizDataCache(){
        sharedPreferences.getString(storageParameter,null)?.let {
            gson.fromJson(it, Videos::class.java).apply {
                videosData.postValue(videos)
            }
        }
    }

    fun getQuizData(){
        var parameter : HashMap<String,String> = HashMap()
        parameter.put("username","VoiceTube")
        parameter.put("password","interview")
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAppQuizData(parameter)
            if (response.isSuccessful){
                response.body()?.apply {
                    videosData.postValue(videos)
                    val videosToJson = gson.toJson(this)
                    sharedPreferences.edit().putString(storageParameter,videosToJson).apply()
                }
            }
        }
    }
    fun storeStatus(switchId : String , switchStatus : Boolean){
        sharedPreferences.edit().putBoolean(switchId,switchStatus).apply()
    }
    fun getStatus(switchId : String) : Boolean{
        return sharedPreferences.getBoolean(switchId,false)
    }
}