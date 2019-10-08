package com.android.sportnmedc.exdata.trades

import com.android.sportnmedc.R
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.user.UserModel

class TradeRepositories:BaseDataSource<TradeModel>{


    companion object {
        private var mList = ArrayList<TradeModel>()
        fun addTradeData(mData:TradeModel){
            mList.add(mData)
        }
    }

    override fun getDataList(): List<TradeModel> {
        return mList
    }

    override fun getDataIndex(index: Int): TradeModel? {
        return if (mList.size > index){
                mList[index]
            }else{
                null
            }
    }

    override fun load(onLoaded: BaseDataSource.OnLoad) {
       mList.clear()
        mList.add(  TradeModel(arrayListOf(R.drawable.b01,R.drawable.b02),arrayListOf(R.drawable.m01), UserModel("Ekachai Sungsup", R.drawable.ex_profile_image,0,0,0)))
        mList.add(  TradeModel(arrayListOf(R.drawable.b04),arrayListOf(R.drawable.b05,R.drawable.m05), UserModel("Adam tomas",R.drawable.ex_profile_image_list,0,0,0)))
        mList.add(  TradeModel(arrayListOf(R.drawable.b01,R.drawable.b02,R.drawable.m02),arrayListOf(R.drawable.m05,R.drawable.b02,R.drawable.m06), UserModel("Mohammad Ali",R.drawable.ex_profile_image_list,0,0,0)))
        onLoaded.onLoaded()
    }

}