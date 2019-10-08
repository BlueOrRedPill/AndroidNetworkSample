package com.android.sportnmedc

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity:BaseActivity(R.layout.activity_result),ToolbarHelper{


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? = "Buakaw Banchamek"


    private var isSell:Boolean =true

    companion object {
        fun newIntent(mActivity: AppCompatActivity,isSell:Boolean): Intent {
            val intent = Intent(mActivity,ResultActivity::class.java)
            intent.putExtra("isSell",isSell)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }
    override fun onActivityCreated() {
        setupToolbar()
        isSell = intent.getBooleanExtra("isSell",true)
        setResult(Activity.RESULT_OK)
        if (isSell){
            image_content.visibility = View.GONE
            success_image.visibility = View.VISIBLE
            message_txt.text = "Your card has been added to the market."
        }else{
            image_content.visibility = View.VISIBLE
            success_image.visibility = View.GONE
            message_txt.text = "This card has been added to your collection."
        }


        confirm_btn.setOnClickListener {
            finish()
        }

    }




}