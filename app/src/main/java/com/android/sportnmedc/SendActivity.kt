package com.android.sportnmedc

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_send.*
import kotlinx.android.synthetic.main.activity_send_detail.amount_txt
import kotlinx.android.synthetic.main.activity_send_detail.confirm_btn


class SendActivity :BaseActivity(R.layout.activity_send), ToolbarHelper {


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Send"
    var amount = ""
    var address = ""
//    data class GroupView(val header:View,val content:View,val icon:ImageView,val button:View,var input:EditText,var isShow:Boolean,var address:String)
//    val arrGroupView = arrayListOf<GroupView>()

    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity,SendActivity::class.java)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
//        arrGroupView.add(GroupView(wallet_header_content,wallet_child_content,wallet_header_navigate,wallet_confirm_btn,wallet_edt,false,""))
//        arrGroupView.add(GroupView(user_header_content,user_child_content,user_header_navigate,user_confirm_btn,user_edt,false,""))
//        arrGroupView.add(GroupView(email_header_content,email_child_content,email_header_navigate,email_confirm_btn,email_edt,false,""))
//        arrGroupView.forEachIndexed { index, groupView ->
//            groupView.input.addTextChangedListener(object:TextWatcher{
//                override fun afterTextChanged(p0: Editable?) {
//                    groupView.address = p0?.trim().toString()
//                }
//
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                }
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                }
//
//            })
//            groupView.header.setOnClickListener { toggleContent(index) }
//            groupView.button.setOnClickListener {
//               val address =  groupView.address
//                if (address.isNullOrEmpty()){
//                    Toast.makeText(mActivity,"The field is empty.",Toast.LENGTH_SHORT).show()
//                }else{
//                    startActivityForResult(SendDetailActivity.newIntent(mActivity,address),Utils.REQUEST_CODE_ADD_COIN)
//                }
//            }
//        }
        id_wallet_edt.addTextChangedListener(object:TextWatcher{
                override fun afterTextChanged(p0: Editable?) {
                    address = p0?.trim().toString()
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

            })
        amount_txt.addTextChangedListener(object: TextWatcher {
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
            if (amount.isNullOrEmpty() || amount.equals("0",true) || address.isNullOrEmpty()){
                Toast.makeText(mActivity,"Please enter id and amount.", Toast.LENGTH_SHORT).show()
            }else{
                startActivityForResult(SendConfirmActivity.newIntent(mActivity,address,amount),
                    Utils.REQUEST_CODE_ADD_COIN)
            }

        }
    }

//    private fun toggleContent(toggleIndex:Int){
//        arrGroupView.forEachIndexed{ index,groupView ->
//            if (groupView.isShow) {
//                groupView.icon.setImageResource(R.drawable.ic_navigate_next)
//                groupView.isShow = false
//                if (toggleIndex == index) {
//                    groupView.content.animate()
//                        .alpha(0.0f)
//                        .setDuration(300)
//                        .setListener(object : AnimatorListenerAdapter() {
//                            override fun onAnimationEnd(animation: Animator) {
//                                super.onAnimationEnd(animation)
//                                groupView.content.visibility = View.GONE
//                            }
//                        })
//                }else{
//                    groupView.content.alpha = 0.0f
//                    groupView.content.visibility = View.GONE
//                }
//
//            }else{
//                if (toggleIndex == index){
//                    groupView.icon.setImageResource(R.drawable.ic_navigate_down)
//                    groupView.isShow = true
//                    groupView.content.animate()
//                        .alpha(1.0f)
//                        .setDuration(300)
//                        .setListener(object : AnimatorListenerAdapter() {
//                            override fun onAnimationStart(animation: Animator?) {
//                                super.onAnimationStart(animation)
//                                groupView.content.visibility = View.VISIBLE
//                            }
//                        })
//                }
//            }
//        }
//    }


}