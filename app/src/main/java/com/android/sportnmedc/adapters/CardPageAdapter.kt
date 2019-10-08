package com.android.sportnmedc.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.android.sportnmedc.fragments.BackCardFragment
import com.android.sportnmedc.fragments.FontCardFragment

class CardPageAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return   if (position == 1){
            BackCardFragment()
        }else{
            FontCardFragment()
        }
    }
}
