package com.android.sportnmedc.fragments

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportnmedc.BaseFragment
import com.android.sportnmedc.LeaderBoardActivity
import com.android.sportnmedc.R
import com.android.sportnmedc.adapters.BaseRecyclerAdapter
import com.android.sportnmedc.adapters.LeaderBoardAdapter
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.user.UserSource
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_header_profile.*

class HomeFragment: BaseFragment(R.layout.fragment_home){

    private var mUserRepositories = UserSource()

    override fun startView(view: View) {
        setUpLeaderBoard()
        setUpProfile()
        addNewContent()
        leaderboard_btn.setOnClickListener {
            startActivity(LeaderBoardActivity.newIntent(mActivity))
        }
    }

    private fun setUpLeaderBoard(){
        val mLeaderBoardAdapter =  LeaderBoardAdapter(mActivity)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.adapter = mLeaderBoardAdapter
        mUserRepositories.load(object: BaseDataSource.OnLoad{
            override fun onLoaded() {
               val index =  mUserRepositories.getDataList().indexOfFirst {  userModel -> userModel.name.equals(mUserRepositories.getCurrentProfile().name,true) }
                mLeaderBoardAdapter.setCurrentUser( mUserRepositories.getCurrentProfile())
                mLeaderBoardAdapter.addData(mUserRepositories.getDataIndex(index-1))
                mLeaderBoardAdapter.addData(mUserRepositories.getDataIndex(index))
                mLeaderBoardAdapter.addData(mUserRepositories.getDataIndex(index+1))
            }
        })
        mLeaderBoardAdapter.setOnItemClick(object : BaseRecyclerAdapter.OnItemClicked{
            override fun onItemClicked(v: View, position: Int) {
            }

        })
    }

    private fun setUpProfile(){
        mUserRepositories.getCurrentProfile().let {
            name_txt.text = it.name
            profile_image.setImageResource(it.imgProfile)
            item_txt.text = it.items.toString()
            complete_txt.text = it.cardQuality.toString()
            score_txt.text = it.score.toString()
        }
    }

    private fun addNewContent(){
        val image = arrayListOf(R.drawable.b01,R.drawable.ej01,R.drawable.m01,R.drawable.v01,R.drawable.j01)
        if (new_content.childCount > 0 ) new_content.removeAllViews()
        for (i in 0..(image.size-1)){
            val view = LayoutInflater.from(mActivity).inflate(R.layout.item_fighter_card,new_content,false)
            view.findViewById<ImageView>(R.id.img_card).apply {
                setImageResource(image[i])
            }
            new_content.addView(view)
        }
    }
}