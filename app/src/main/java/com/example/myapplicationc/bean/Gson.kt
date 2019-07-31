package com.example.myapplicationc.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.myapplicationc.BR

class Gson: BaseObservable() {
	@Bindable
	public var name:String = "Bindable"
	set(value) {
		field = value
		notifyPropertyChanged(BR.name)
	}
	get() {
		notifyChange()
		return field
	}
	private var details : String? = null
	var price : Float = 0.0f
	
	
	//只更新本字段
	//notifyPropertyChanged(com.example.myapplicationc.)
	
	@Bindable
	fun getDetails() : String? {
		return details
	}

	fun setDetails(details : String) {
		this.details = details
		//更新所有字段
		notifyChange()
	}

	override fun toString() : String {
		return "Goods{" +
				"name='" + name + '\''.toString() +
				", details='" + details + '\''.toString() +
				", price=" + price +
				'}'.toString()
	}
}
