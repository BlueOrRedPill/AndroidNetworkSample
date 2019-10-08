package com.android.sportnmedc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_receive.*

class ReceiveActivity :BaseActivity(R.layout.activity_receive), ToolbarHelper {


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Receive"
    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity,ReceiveActivity::class.java)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        buy_with_credit_btn.setOnClickListener {
            startActivityForResult(PaymentActivity.newIntent(mActivity), Utils.REQUEST_CODE_ADD_COIN)
        }


        user_id.setOnClickListener {
            Utils.copyToClipboard(mActivity,user_id.text.toString())
        }
        copy_clipboard.setOnClickListener {
            Utils.copyToClipboard(mActivity,copy_clipboard.text.toString())
        }
    }

}