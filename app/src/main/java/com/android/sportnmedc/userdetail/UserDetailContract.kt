package com.android.sportnmedc.userdetail

import com.android.sportnmedc.BasePresenter
import com.android.sportnmedc.BaseView
import com.android.sportnmedc.exdata.trades.TradeModel
import com.android.sportnmedc.exdata.user.UserModel

interface UserDetailContract{
    interface View:BaseView<Presenter>{
        fun showProfile(mProfile:UserModel)

        fun showSelectItem(itemIn:Boolean,mTradeModel:TradeModel)

    }

    interface Presenter:BasePresenter{
        fun openSelectItem()

    }
}