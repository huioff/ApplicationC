package com.example.myapplicationc

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplicationc.databinding.BindingUser

abstract class XBaseFragment: Fragment(){
    
    var binding:BindingUser ? = null
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),null,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onResume() {
        super.onResume()
        initListeners()
    }

    open fun initListeners() {}

    open fun initViews(){}

    abstract fun getLayoutId():Int

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig) //屏幕旋转时刷新一下
        initViews()
    }


}