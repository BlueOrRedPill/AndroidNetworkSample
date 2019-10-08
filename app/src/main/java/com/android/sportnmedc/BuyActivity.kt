package com.android.sportnmedc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_sell_card.*

class BuyActivity:BaseActivity(R.layout.activity_buy_card),ToolbarHelper{


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Buakaw Banchamek"

    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity,BuyActivity::class.java)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }
    override fun onActivityCreated() {
        setupToolbar()
        confirm_btn.setOnClickListener {
            startActivityForResult(SellConfirmActivity.newIntent(mActivity,-1), Utils.REQUEST_CODE_BUYSELL)
        }

    }




}