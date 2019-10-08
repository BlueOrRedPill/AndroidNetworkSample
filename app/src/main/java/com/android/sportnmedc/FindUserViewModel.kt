package com.android.sportnmedc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.sportnmedc.datas.UserRepositories
import com.android.sportnmedc.exdata.user.UserModel

class FindUserViewModel :ViewModel(){

   private val mUserRepositories = UserRepositories()

    fun getUser(): LiveData<List<UserModel>> {
        return mUserRepositories.getDataList()
    }
}