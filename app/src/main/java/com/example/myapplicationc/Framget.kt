package com.example.myapplicationc

import com.example.myapplicationc.bean.Gson
import com.example.myapplicationc.viewmodel.FramgetContet
import kotlinx.android.synthetic.main.framget_layout.*

class Framget : XBaseFragment(){
	
	override fun getLayoutId() : Int = R.layout.framget_layout
	
	override fun initViews() {
		super.initViews()
		val gson = Gson()
		binding!!.gson = gson
		binding!!.fc = FramgetContet()
//		framget_button.setOnClickListener {
//			//user.RealTime("啦啦测试")
//			gson.name = "啦啦测试"
//
//		}
	}
	
}