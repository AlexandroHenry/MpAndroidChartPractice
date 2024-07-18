package com.ret.mpandroidchartpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LineChartViewModel : ViewModel() {
    private val _priceLiveData = MutableLiveData<String>()
    val priceLiveData: LiveData<String> get() = _priceLiveData

    fun setPrice(price: String) {
        _priceLiveData.value = price
    }
}