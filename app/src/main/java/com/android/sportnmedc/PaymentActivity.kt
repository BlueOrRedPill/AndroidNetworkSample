package com.android.sportnmedc

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity:BaseActivity(R.layout.activity_payment),ToolbarHelper{



    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Buy with Credit Card"

    var amount = "0"
    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity,PaymentActivity::class.java)
            return intent
        }
    }
    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        price_edt.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                amount = p0?.trim().toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
        confirm_btn.setOnClickListener {
            while (amount.startsWith("0")){
                amount = amount.removePrefix("0")
            }
            if (amount.isNullOrEmpty() || amount.equals("0")){
                Toast.makeText(mActivity,"Please enter amount.", Toast.LENGTH_SHORT).show()
            }else{
                startActivityForResult(PaymentResultActivity.newIntent(mActivity,amount), Utils.REQUEST_CODE_ADD_COIN)
            }

        }
    }





}