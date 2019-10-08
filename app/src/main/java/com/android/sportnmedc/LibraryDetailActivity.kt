package com.android.sportnmedc

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.exdata.libraries.LibraryModel
import com.android.sportnmedc.exdata.libraries.LibraryRespositories
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.helpers.Utils
import kotlinx.android.synthetic.main.activity_library_detail.*
import kotlin.random.Random

class LibraryDetailActivity:BaseActivity(R.layout.activity_library_detail),ToolbarHelper{


    private var imageList:ArrayList<Int> ?= null

    companion object {
        fun newIntent(mActivity: AppCompatActivity,mData:LibraryModel): Intent {
            val intent = Intent(mActivity,LibraryDetailActivity::class.java)
            intent.putExtra("library",mData)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun hasBackMenu(): Boolean =true

    override fun onActivityCreated() {
        setupToolbar()

        card_content.setOnClickListener {
            startActivityForResult(CardDetailActivity.newIntent(mActivity,0),Utils.REQUEST_CODE_BUYSELL)
        }

        intent.getParcelableExtra<LibraryModel>("library").let {
            mToolbar?.setToolbarTitle(it.name)
            cover_img.setImageResource(it.imageCover)
            name_txt.text = it.name
            percent_all_txt.text = "${it.currentCount}/${it.maxCount} complete"
            imageList = LibraryRespositories.getLibraryItems(it.name)
            addCardDemo()
        }

    }

    private fun addCardDemo(){
        if (card_content.childCount > 0) card_content.removeAllViews()
        val size = imageList?.size?:0
        val level =  if (size > 6) 2 else if (size > 3) 1 else 0
        for (i in 0..level){
            val view = LayoutInflater.from(mActivity).inflate(R.layout.item_card_blog,card_content,false)
            val container:ArrayList<FrameLayout> = arrayListOf(view.findViewById(R.id.container_1), view.findViewById(R.id.container_2), view.findViewById(R.id.container_3))
            val image:ArrayList<ImageView> = arrayListOf(view.findViewById(R.id.image_1), view.findViewById(R.id.image_2), view.findViewById(R.id.image_3))
            val count:ArrayList<TextView> = arrayListOf(view.findViewById(R.id.count_1), view.findViewById(R.id.count_2), view.findViewById(R.id.count_3))
            for (j in 0..2){
                val index = i*3+j
                updateItemView(container[j],image[j],count[j],index)
            }
//            val index1 = i*3 + 0
//            val index2 = i*3 + 1
//            val index3 = i*3 + 2
//            val count1:ImageView = view.findViewById(R.id.count_1)
//            val count2:ImageView = view.findViewById(R.id.count_1)
//            val count3:ImageView = view.findViewById(R.id.count_1)
//            updateItemView(image1,index1)
//            updateItemView(image2,index2)
//            updateItemView(image3,index3)
            card_content.addView(view)
        }
    }

    private fun updateItemView(container:FrameLayout,imageView:ImageView,countView:TextView,index:Int){
        container.visibility = View.INVISIBLE
        imageList?.let {
            if (index < it.size){
                container.visibility = View.VISIBLE
                imageView.setImageResource(it[index])
                countView.text = "X ${Random.nextInt(5)+1}"
            }
        }
    }



}