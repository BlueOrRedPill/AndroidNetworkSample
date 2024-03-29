package com.android.sportnmedc.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.sportnmedc.exdata.user.UserModel
import java.util.*




/**
 * Created by AndroidEB on 10/9/2017.
 */
class UserTradeAdapter(mActivity:AppCompatActivity):BaseRecyclerAdapter(mActivity), Filterable {



    private var mTotalPage = 1
    private var mDataList:ArrayList<UserModel?> = ArrayList()
    private var mBackupDataList:ArrayList<UserModel?> = ArrayList()
    override fun getItemCount(): Int {
        return mDataList.size
    }

    fun getItem(postion:Int):UserModel?{
        return if (postion < mDataList.size) mDataList[postion] else null
    }

    fun clear(){
        mBackupDataList.clear()
        mDataList.clear()
        notifyDataSetChanged()
    }
    fun addData(mData:UserModel?) {
        mDataList.add(mData)
        notifyItemInserted(mDataList.size - 1)
    }

    fun addDataAll(mDataList: List<UserModel>, mTotalPage: Int) {
        this.mTotalPage = mTotalPage
        val size = this.mDataList.size
        this.mDataList.addAll(mDataList)
        mBackupDataList.addAll(mDataList)
        notifyItemRangeInserted(size, mDataList.size)

    }

    fun startLoading(mLayoutManager: RecyclerView.LayoutManager, currentPage: Int) {
        var currentPage = currentPage
        val layout = (mLayoutManager as? GridLayoutManager)?:mLayoutManager as LinearLayoutManager
        if (layout.itemCount > 0 && currentPage < mTotalPage) {
            val visibleThreshold = 2
            val totalItemCount = layout.itemCount
            val lastVisibleItem = layout.findLastVisibleItemPosition()
            if (!isLoading() && totalItemCount <= lastVisibleItem + visibleThreshold) {
                Log.e("page", "" + currentPage)
                setLoaded(true)
                if (mOnLoadMoreListener != null) {
                    addData(null)
                    currentPage++
                    mOnLoadMoreListener?.onLoadMore(currentPage)
                }
            }
        }
    }

    fun removeLoadingItem() {
        if (mDataList.size > 0) {
            if (mDataList.last() == null) {
                mDataList.removeAt(mDataList.lastIndex)
            }
        }
        setLoaded(false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            ItemHolder(LayoutInflater.from(parent.context).inflate(com.android.sportnmedc.R.layout.item_user_trade, parent, false))
        } else super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemHolder -> {
                mDataList.get(position)?.let {
                    holder.updateContent(it)
                }

            }
            else -> super.onBindViewHolder(holder, position)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (mDataList[position]== null) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }



    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(com.android.sportnmedc.R.id.user_name)
        val profileImage: ImageView = itemView.findViewById(com.android.sportnmedc.R.id.profile_image)


        init {
            itemView.setOnClickListener {
                onItemClicked?.onItemClicked(it,adapterPosition)


            }
        }


        fun updateContent(mData:UserModel){
            userName.text = mData.name
            profileImage.setImageResource(mData.imgProfile)
        }
    }
    override fun getFilter(): Filter {
        return nameFilter
    }

    private var nameFilter: Filter = object : Filter() {

        override  fun performFiltering(constraint: CharSequence?): FilterResults {
            val charString = constraint.toString()
            var  mFilterDataList  = ArrayList<UserModel?>()
            if (charString.isEmpty()) {
                mFilterDataList.addAll(mBackupDataList)
            } else {
                val filteredList = ArrayList<UserModel?>()
                for (row in mBackupDataList) {
                    if (row?.name?.toLowerCase()?.startsWith(charString.toLowerCase(),true) == true) {
                        filteredList.add(row)
                    }
                }
                mFilterDataList = filteredList
            }

            val filterResults = FilterResults()
            filterResults.values = mFilterDataList
            filterResults.count = mFilterDataList.size
            return filterResults
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults?) {
            mDataList.clear()
            if (results != null && results.count > 0) {
                mDataList.addAll(results.values as ArrayList<UserModel>)
            }
            notifyDataSetChanged()
        }
    }


}