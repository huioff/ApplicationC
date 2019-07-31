package com.example.myapplicationc.viewmodel

import android.util.Log
import com.example.myapplicationc.bean.Gson
import kotlin.random.Random

class FramgetContet {
	fun updateText(gson : Gson){
		Log.e("159357","测试单机效果")
		gson.name = "updateText:${Random.nextInt(100)}"
	}
}