package com.android.sportnmedc

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_sell_card_confirm.*

class SellConfirmActivity:BaseActivity(R.layout.activity_sell_card_confirm),ToolbarHelper{


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? = "Confirmation"


    private var price:Int =0

    companion object {
        fun newIntent(mActivity: AppCompatActivity,price:Int): Intent {
            val intent = Intent(mActivity,SellConfirmActivity::class.java)
            intent.putExtra("price",price)
            return intent
        }
    }
    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        price = intent.getIntExtra("price",0)
        if (price == -1){
            sell_detail.visibility = View.GONE
            message_txt.text = "1000.00 EXS will be send to David."
            confirm_btn.setOnClickListener {
                startActivityForResult(ResultActivity.newIntent(mActivity,false),Utils.REQUEST_CODE_BUYSELL)
            }
        }else{
            sell_detail.visibility = View.VISIBLE
            message_txt.text = "$price EXS will be put on Marketplace."
            confirm_btn.setOnClickListener {
                startActivityForResult(ResultActivity.newIntent(mActivity,true),Utils.REQUEST_CODE_BUYSELL)
            }
        }


    }




}