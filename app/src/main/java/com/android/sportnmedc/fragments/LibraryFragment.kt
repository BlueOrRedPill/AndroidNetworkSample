package com.android.sportnmedc.fragments

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportnmedc.BaseFragment
import com.android.sportnmedc.LibraryDetailActivity
import com.android.sportnmedc.R
import com.android.sportnmedc.adapters.BaseRecyclerAdapter
import com.android.sportnmedc.adapters.LibraryAdapter
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.libraries.LibraryRespositories
import com.android.sportnmedc.helpers.Utils
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment: BaseFragment(R.layout.fragment_library){

    private var imageList:ArrayList<Int> ?= null
    private var mLibraryRespositories = LibraryRespositories()

    override fun startView(view: View) {
        imageList = LibraryRespositories.getOnSale()
        tab_home.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                p0?.let {
                    updateData(it.position)
                }
            }

        })
        updateData(0)
    }

    fun updateData(index:Int){
        when(index){
            0->   {
                recyclerView.visibility = View.VISIBLE
                onsale_content.visibility = View.GONE
                val mAdapter =  LibraryAdapter(mActivity)
                recyclerView.layoutManager = LinearLayoutManager(mActivity)
                recyclerView.adapter = mAdapter
                mLibraryRespositories.load(object: BaseDataSource.OnLoad{
                    override fun onLoaded() {
                        mAdapter.addDataAll(mLibraryRespositories.getDataList(),1)
                    }
                })
                mAdapter.setOnItemClick(object:BaseRecyclerAdapter.OnItemClicked{
                    override fun onItemClicked(v: View, position: Int) {
                        mAdapter.getItem(position)?.let {
                            startActivityForResult(LibraryDetailActivity.newIntent(mActivity,it),Utils.REQUEST_CODE_BUYSELL)
                        }
                    }

                })
            }
            1->   {
                recyclerView.visibility = View.GONE
                onsale_content.visibility = View.VISIBLE
                addCardDemo()
//                val mCardAdapter =   MarketAdapter(mActivity,MarketAdapter.TYPE.ON_SALE)
//                recyclerView.layoutManager = GridLayoutManager(mActivity,3)
//                recyclerView.adapter = mCardAdapter
//
//                mCardAdapter.addDataAll(DataHelper().get3Card(),1)
//                mCardAdapter.setOnItemClick(object :BaseRecyclerAdapter.OnItemClicked{
//                    override fun onItemClicked(v: View, position: Int) {
//                        tab_home.getTabAt(0)?.select()
//                    }
//
//                })
            }
        }

    }
    private fun addCardDemo(){
        if (card_content.childCount > 0) card_content.removeAllViews()
        for (i in 0..2){
            val view = LayoutInflater.from(mActivity).inflate(R.layout.item_card_blog,card_content,false)
            val image1: ImageView = view.findViewById(R.id.image_1)
            val image2: ImageView = view.findViewById(R.id.image_2)
            val image3: ImageView = view.findViewById(R.id.image_3)
            imageList?.let {
                image1.setImageResource(it[i*3 + 0])
                image2.setImageResource(it[i*3 + 1])
                image3.setImageResource(it[i*3 + 2])
            }

            card_content.addView(view)
        }
    }

}