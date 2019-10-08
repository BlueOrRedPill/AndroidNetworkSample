package com.android.sportnmedc.fragments

import android.view.View
import com.android.sportnmedc.BaseFragment
import com.android.sportnmedc.CardDetailActivity
import com.android.sportnmedc.R
import com.android.sportnmedc.adapters.BaseRecyclerAdapter
import com.android.sportnmedc.adapters.MarketAdapter
import com.android.sportnmedc.exdata.BaseDataSource
import com.android.sportnmedc.exdata.markets.MarketRepositories
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.fragment_market.*

class MarketFragment: BaseFragment(R.layout.fragment_market){

    private var mMarketRepositories = MarketRepositories()
    var mCardAdapter:MarketAdapter ?= null

    private var isDescending = false
    override fun startView(view: View) {
        mCardAdapter =   MarketAdapter(mActivity,MarketAdapter.TYPE.BUY)
        recyclerView.adapter =mCardAdapter
        mMarketRepositories.load(object:BaseDataSource.OnLoad{
            override fun onLoaded() {
                updateContent(isDescending)
            }

        })
        mCardAdapter?.setOnItemClick(object:BaseRecyclerAdapter.OnItemClicked{
            override fun onItemClicked(v: View, position: Int) {
                mCardAdapter?.getItem(position)?.let {
                    startActivityForResult(CardDetailActivity.newIntent(mActivity,it.price),Utils.REQUEST_CODE_BUYSELL)
                }
            }

        })

        sort_price.setOnClickListener {
            updateContent(!isDescending)
        }
    }

    private fun updateContent(toggle:Boolean){
        isDescending = toggle
        sort_image.rotation = if (isDescending) 90f else 0f
        mMarketRepositories.sort(isDescending)
        if ( mCardAdapter?.itemCount?:0 > 0){
            mCardAdapter?.clear()
        }
        mCardAdapter?.addDataAll(mMarketRepositories.getDataList(),1)
    }

}