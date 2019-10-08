package com.android.sportnmedc

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportnmedc.adapters.BaseRecyclerAdapter
import com.android.sportnmedc.adapters.LeaderBoardAdapter
import com.android.sportnmedc.datas.UserRepositories
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.user.UserModel
import com.android.sportnmedc.exdata.user.UserSource
import com.android.sportnmedc.helpers.ToolbarHelper
import kotlinx.android.synthetic.main.activity_leaderboard.*
import kotlinx.android.synthetic.main.layout_header_profile.*

class LeaderBoardActivity:BaseActivity(R.layout.activity_leaderboard),ToolbarHelper{


    private var mUserRepositories = UserSource()

    companion object {
        fun newIntent(mActivity:AppCompatActivity):Intent{
            val intent = Intent(mActivity,LeaderBoardActivity::class.java)
            return intent
        }
    }

    override fun hasBackMenu(): Boolean =true

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        setUpProfile()
        setUpLeaderBoard()
    }

    private fun setUpProfile(){
        mUserRepositories.getCurrentProfile().let {
            mToolbar?.setToolbarTitle(it.name)
            name_txt.text = it.name
            profile_image.setImageResource(it.imgProfile)
            item_txt.text = it.items.toString()
            complete_txt.text = it.cardQuality.toString()
            score_txt.text = it.score.toString()
        }

    }

    private fun setUpLeaderBoard(){
        val mLeaderBoardAdapter =  LeaderBoardAdapter(mActivity)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.adapter = mLeaderBoardAdapter

        var repositories = UserRepositories()
        repositories.getDataList().observe(this,
            Observer<List<UserModel>> { userModels -> userModels.size })



        mUserRepositories.load(object: BaseDataSource.OnLoad{
            override fun onLoaded() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                mUserRepositories.getDataList().find{
                    mUserRepositories.getCurrentProfile().name.equals(it.name,true)
                }?.also {  }
            }

        })

        mUserRepositories.load(object: BaseDataSource.OnLoad{
            override fun onLoaded() {
                mLeaderBoardAdapter.setCurrentUser( mUserRepositories.getCurrentProfile())
                mUserRepositories.getDataList().find {
                    mUserRepositories.getCurrentProfile().name.equals(it.name,true)
                }?.also {
                    current_profile_image.setImageResource(it.imgProfile)
                    current_name_txt.text = it.name
                    current_rank_txt.text =(  mUserRepositories.getDataList().indexOf(it)+1).toString()
                    current_item_txt.text = it.items.toString()
                    current_score_txt.text = it.score.toString()
                }.let { userModel ->
                  val mList =  mUserRepositories.getDataList().filterNot { userModel?.name.equals(it.name,true)}
                    mLeaderBoardAdapter.addDataAll(mList,1)
                }
            }
        })
        mLeaderBoardAdapter.setOnItemClick(object : BaseRecyclerAdapter.OnItemClicked{
            override fun onItemClicked(v: View, position: Int) {
            }

        })
    }
}