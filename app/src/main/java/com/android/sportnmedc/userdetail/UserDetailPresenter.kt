package com.android.sportnmedc.userdetail

import com.android.sportnmedc.exdata.trades.TradeModel
import com.android.sportnmedc.exdata.user.UserModel

class UserDetailPresenter(var mUser: UserModel,var mView:UserDetailContract.View):UserDetailContract.Presenter{


    init {
        mView.setPresenter(this)
    }


    override fun start() {
        mView.showProfile(mUser)
    }

    override fun openSelectItem() {
        mView.showSelectItem(true, TradeModel(ArrayList(),ArrayList(),mUser))

    }

}