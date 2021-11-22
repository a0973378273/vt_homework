package priv.jb.homework.activity

import android.os.Bundle
import android.widget.CompoundButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.setting.*
import priv.jb.homework.R
import priv.jb.homework.viewmodel.AppQuizViewModel

@AndroidEntryPoint
class SettingActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {
    private val appQuizViewModel : AppQuizViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)
        autoplay.setOnCheckedChangeListener(this)
        wordsync.setOnCheckedChangeListener(this)
        pauseplay.setOnCheckedChangeListener(this)
        remind.setOnCheckedChangeListener(this)
        inform.setOnCheckedChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        autoplay.isChecked = appQuizViewModel.getStatus("autoplay")
        wordsync.isChecked = appQuizViewModel.getStatus("wordsync")
        pauseplay.isChecked = appQuizViewModel.getStatus("pauseplay")
        remind.isChecked = appQuizViewModel.getStatus("remind")
        inform.isChecked = appQuizViewModel.getStatus("inform")
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        appQuizViewModel.storeStatus(buttonView?.tag.toString(),isChecked)
    }

}