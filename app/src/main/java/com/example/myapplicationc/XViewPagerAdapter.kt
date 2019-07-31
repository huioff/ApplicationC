package com.example.myapplicationc



import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

@SuppressLint("WrongConstant")
class XViewPagerAdapter(fm: FragmentManager?, basfm:List<XBaseFragment>):
    FragmentStatePagerAdapter(fm!!){
    private var basfms = basfm
    override fun getItem(i: Int): Fragment {
       return basfms[i]
    }
    override fun getCount(): Int {
      return basfms.size
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {}
}