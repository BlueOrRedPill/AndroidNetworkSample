package com.android.sportnmedc.fragments

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.sportnmedc.BaseFragment
import com.android.sportnmedc.R
import com.android.sportnmedc.adapters.TransactionAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.item_back_card.*
import kotlinx.android.synthetic.main.item_card_transaction.*

class BackCardFragment: BaseFragment(R.layout.item_back_card){


    override fun startView(view: View) {
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
                transaction_content.visibility = View.GONE
                info_content.visibility = View.VISIBLE
            }
            1->   {
                transaction_content.visibility = View.VISIBLE
                info_content.visibility = View.GONE
                updateTransaction()
            }
        }

    }

    private fun updateTransaction(){
        val mAdapter =  TransactionAdapter(mActivity)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.adapter = mAdapter
    }
}