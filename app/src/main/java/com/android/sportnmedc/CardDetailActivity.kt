package com.android.sportnmedc

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.adapters.CardPageAdapter
import com.android.sportnmedc.helpers.FlipPageViewTransformer
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_card_detail.*

class CardDetailActivity:BaseActivity(R.layout.activity_card_detail),ToolbarHelper{


    private var price:Int = 0

    companion object {
        fun newIntent(mActivity:AppCompatActivity,price:Int):Intent{
            val intent = Intent(mActivity,CardDetailActivity::class.java)
            intent.putExtra("price",price)
            return intent
        }
    }
    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? ="Buakaw Banchamek"

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }
    override fun onActivityCreated() {
        setupToolbar()
        price = intent.getIntExtra("price",0)
        viewpager.adapter = CardPageAdapter(supportFragmentManager)
        viewpager.setPageTransformer(true,FlipPageViewTransformer())
        if (price == 0){
            confirm_image.visibility = View.GONE
            confirm_txt.text = "SELL"
            confirm_btn.setOnClickListener {
                startActivityForResult(SellActivity.newIntent(mActivity), Utils.REQUEST_CODE_BUYSELL)
            }
        }else{
            confirm_image.visibility = View.VISIBLE
            confirm_txt.text = "BUY $price EXS"
            confirm_btn.setOnClickListener {
                startActivityForResult(BuyActivity.newIntent(mActivity), Utils.REQUEST_CODE_BUYSELL)
//                DialogHelper.createConfirmDialog(mActivity,getString(R.string.app_name),"Do you want to buy this card ?",
//                    DialogInterface.OnClickListener { _,_ ->
//                        startActivityForResult(ResultActivity.newIntent(mActivity,false),Utils.REQUEST_CODE_BUYSELL)
//                    }).show()
            }
        }
        tap_btn.setOnClickListener {
            if (viewpager.currentItem == 0){
                viewpager.setCurrentItem(1,true)
            }else{
                viewpager.setCurrentItem(0,true)
            }

        }
//        setUpProfile()
//        supportFragmentManager.beginTransaction().replace(R.id.user_detail_content,LibraryFragment()).commitNowAllowingStateLoss()
    }

//    private fun setUpProfile(){
//       intent.getParcelableExtra<UserModel>("user").let {
//            name_txt.text = it.name
//            profile_image.setImageResource(it.imgProfile)
//            item_txt.text = it.items.toString()
//            complete_txt.text = it.cardQuality.toString()
//            score_txt.text = it.score.toString()
//        }
//
//    }
}