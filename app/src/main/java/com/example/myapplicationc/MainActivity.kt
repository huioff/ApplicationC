package com.example.myapplicationc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplicationc.bean.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var name:String = "测试初始化"
    var basfm = mutableListOf<XBaseFragment>()

    //更新 name参数
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding.user = User()
        // Example of a call to a native method
        //sample_text.text = stringFromJNI()
        //调用该方法在C中实现更新name参数
        //Log.e("159357","输出修改前:$age")
        //updateName()
        //updateAge()
        //Log.e("159357","输出修改后:$age")
        basfm.add(Framget())
        sample_viewpaager.adapter = XViewPagerAdapter(supportFragmentManager,basfm)
        //sample_text.setTextColor(ContextCompat.getColor(this,R.color.abc_btn_colored_borderless_text_material))
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String
    private external fun updateName()
    private external fun updateAge()
    private external fun getNumber()
    
    //生成随机数
    fun getRandomInt(max:Int):Int = Random(10).nextInt(max)
    
    companion object {
        var age:Int = 19
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
