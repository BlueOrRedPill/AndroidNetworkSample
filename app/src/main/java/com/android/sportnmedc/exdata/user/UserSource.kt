package com.android.sportnmedc.exdata.user

import com.android.sportnmedc.R
import com.android.sportnmedc.exdata.BaseDataSource
import java.util.*

class UserSource:BaseDataSource<UserModel>{


    private var mCurrentProfile:UserModel = UserModel("Ekachai Sungsup",R.drawable.ex_profile_image,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10))

    private var mList:ArrayList<UserModel> = ArrayList()


    fun getCurrentProfile():UserModel{
        return mCurrentProfile
    }

    override fun getDataList(): List<UserModel> {
      return mList
    }

    override fun getDataIndex(index:Int): UserModel? {
      return mList[index]
    }


    override fun load(onLoaded: BaseDataSource.OnLoad) {
        loadFromDB()
        onLoaded.onLoaded()
    }

    override fun loadFromNetwork() {

    }

    override fun loadFromDB() {
        if (mList.isEmpty()){
            mList.add(UserModel("Tony",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Gustavo",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Ekachai sungsup",R.drawable.ex_profile_image,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Leo",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Micheal",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("David",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Salah",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Muhammed",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Enriko",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("Ronaldo",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))
            mList.add(UserModel("William",R.drawable.ex_profile_image_list,Random().nextInt(1000),Random().nextInt(200),Random().nextInt(10)))

        }
    }





}