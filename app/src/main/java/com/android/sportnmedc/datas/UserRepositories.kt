package com.android.sportnmedc.datas

import androidx.lifecycle.MutableLiveData
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.user.UserModel
import com.android.sportnmedc.exdata.user.UserSource

class UserRepositories :BaseRepositories<UserModel>{

    val dataSource = UserSource()

    override fun getDataList(): MutableLiveData<List<UserModel>>{
        val  mUserLiveData: MutableLiveData<List<UserModel>> = MutableLiveData()
        dataSource.load(object:BaseDataSource.OnLoad{
            override fun onLoaded() {
                mUserLiveData.value = dataSource.getDataList()
            }

        })
        return  mUserLiveData
    }

    override fun getDataIndex(index: Int):  MutableLiveData<UserModel>{
        val  mUserLiveData: MutableLiveData<UserModel> = MutableLiveData()
        dataSource.getDataIndex(index)?.apply {
            mUserLiveData.value = this
        }
        return   mUserLiveData
    }



}