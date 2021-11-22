package priv.jb.homework.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import priv.jb.homework.R
import priv.jb.homework.adapter.RecycleViewAdapter
import priv.jb.homework.viewmodel.AppQuizViewModel
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val appQuizViewModel : AppQuizViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appQuizViewModel.videosData.observe(this, Observer {
            recycleview.adapter = RecycleViewAdapter(it)
        })
        appQuizViewModel.getQuizDataCache()
        appQuizViewModel.getQuizData()
    }
    fun onClick(view:View){
        when(view.id)
        {
            R.id.setting -> startActivity(Intent(this,SettingActivity::class.java))
            R.id.countdown -> startActivity(Intent(this,CountdownActivity::class.java))
        }
    }
}