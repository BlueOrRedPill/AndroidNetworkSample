package com.android.sportnmedc.userdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.transaction
import com.android.sportnmedc.BaseActivity
import com.android.sportnmedc.R
import com.android.sportnmedc.SelectItemActivity
import com.android.sportnmedc.exdata.trades.TradeModel
import com.android.sportnmedc.exdata.user.UserModel
import com.android.sportnmedc.fragments.LibraryFragment
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_user_detail.*
import kotlinx.android.synthetic.main.layout_header_profile.*

class UserDetailActivity: BaseActivity(R.layout.activity_user_detail),UserDetailContract.View,ToolbarHelper{



    private var  mPresenter: UserDetailContract.Presenter?=null

    companion object {
        fun newIntent(mActivity:AppCompatActivity,mUser:UserModel):Intent{
            val intent = Intent(mActivity, UserDetailActivity::class.java)
            intent.putExtra("user",mUser)
            return intent
        }
    }
    override fun hasBackMenu(): Boolean =true

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        UserDetailPresenter(intent.getParcelableExtra("user"),this)
        mPresenter?.start()
        supportFragmentManager.transaction(allowStateLoss = true) {
            replace(R.id.user_detail_content,LibraryFragment())
        }

        exchange_btn.setOnClickListener {   mPresenter?.openSelectItem() }

    }

    override fun showProfile(mProfile: UserModel) {
        mToolbar?.setToolbarTitle(mProfile.name)
        name_txt.text = mProfile.name
        profile_image.setImageResource(mProfile.imgProfile)
        item_txt.text = mProfile.items.toString()
        complete_txt.text = mProfile.cardQuality.toString()
        score_txt.text = mProfile.score.toString()
    }

    override fun showSelectItem(itemIn: Boolean, mTradeModel: TradeModel) {
        startActivityForResult(
            SelectItemActivity.newIntent(
                mActivity,
                mTradeModel
            ), Utils.REQUEST_CODE_TRADE)
    }

    override fun setPresenter(mPresenter: UserDetailContract.Presenter) {
        this.mPresenter = mPresenter
    }
}