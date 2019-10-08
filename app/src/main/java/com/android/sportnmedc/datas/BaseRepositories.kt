package com.android.sportnmedc.datas

import androidx.lifecycle.MutableLiveData

interface BaseRepositories<T>{

    fun getDataList(): MutableLiveData<List<T>>
    fun getDataIndex(index:Int): MutableLiveData<T>


}