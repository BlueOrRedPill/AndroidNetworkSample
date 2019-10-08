package com.android.sportnmedc

import android.content.Intent
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_send_confirm.*
import java.util.*

class SendConfirmActivity :BaseActivity(R.layout.activity_send_confirm), ToolbarHelper {


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Confirmation"
    data class Item(val key:String,val value:String)

    val data =  ArrayList<Item>()


//
//    data class GroupView(val header:View,val content:View,val icon:ImageView,var isShow:Boolean)
//    val arrGroupView = arrayListOf<GroupView>()

    companion object {
        fun newIntent(mActivity: AppCompatActivity, address:String, amount:String): Intent {
            val intent = Intent(mActivity,SendConfirmActivity::class.java)
            intent.putExtra("address",address)
            intent.putExtra("amount",amount)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        var amount = "0"
        var address = ""
        intent.extras?.let {
            amount = it.getString("amount","0")
            address = it.getString("address","")
            data.add(Item("RECEIVEMENT'S ADDRESS",address  ))
            data.add(Item("AMOUNT TO RECEIVE",amount+" EXS"))
            amount_txt.text = amount+" EXS"
        }



        if (confirm_container.childCount > 0) confirm_container.removeAllViews()
        for (i in 0 until data.size){
            val v = LayoutInflater.from(mActivity).inflate(R.layout.item_transaction_detail,confirm_container,false)
            val keyTxt: TextView = v.findViewById(R.id.key)
            val valueTxt: TextView = v.findViewById(R.id.value)
            data[i].let { item->
                keyTxt.text = item.key
                valueTxt.text = item.value
            }
            confirm_container.addView(v)
        }

        confirm_txt.text = "Withdraw $amount EXS"
        confirm_btn.setOnClickListener {
            startActivityForResult(SendResultActivity.newIntent(mActivity,address,amount),Utils.REQUEST_CODE_ADD_COIN)
        }

    }



}