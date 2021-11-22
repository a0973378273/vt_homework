package priv.jb.homework.viewmodel

import android.content.SharedPreferences
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountdownViewModel @Inject constructor(
    val sharedPreferences: SharedPreferences
    ): ViewModel(){

    var countDownTimer : CountDownTimer? = null
    val remainTimer : MutableLiveData<String> = MutableLiveData()
    fun setCountDown(millsecond:Long){
        countDownTimer?.cancel()
        countDownTimer = object : CountDownTimer(millsecond,1000){
            override fun onFinish() {
                remainTimer.value = "0"
            }

            override fun onTick(millisUntilFinished: Long) {
                remainTimer.value = (millisUntilFinished/1000).toString()
            }
        }.start()
    }
    fun pauseCountdown(){
        remainTimer.value?.let {
            var millsecond = it.toLong()*1000
            sharedPreferences.edit().putLong("countdown",millsecond).apply()
        }
        countDownTimer?.cancel()
    }
    fun continueCountdown(){
        var countdownSecond = sharedPreferences.getLong("countdown",0)
        if(countdownSecond > 0 ){
            setCountDown(countdownSecond)
        }
    }
}