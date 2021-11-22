package priv.jb.homework.activity

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.android.synthetic.main.countdown.*
import priv.jb.homework.R
import priv.jb.homework.viewmodel.CountdownViewModel

@AndroidEntryPoint
class CountdownActivity : AppCompatActivity() {
    val countdownViewModel : CountdownViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown)
        countdownViewModel.remainTimer.observe(this, Observer {
            countdownSecond.text = it
        })
    }

    override fun onResume() {
        super.onResume()
        countdownViewModel.continueCountdown()
    }
    override fun onPause() {
        super.onPause()
        countdownViewModel.pauseCountdown()
    }

    fun onClick(view: View){
        countdownViewModel.setCountDown(secondInput.text.toString().toLong()*1000)
    }
}