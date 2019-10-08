package com.android.sportnmedc

import android.content.ContentResolver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import kotlinx.android.synthetic.main.activity_register.*
import android.net.Uri
import android.provider.MediaStore
import com.android.sportnmedc.network.SampleRepositories
import com.orhanobut.logger.Logger
import java.io.File


class RegisterActivity:BaseActivity(R.layout.activity_register),ToolbarHelper{


    override fun hasBackMenu(): Boolean =true
    override fun toolbarTitle(): String? = ""

    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity,RegisterActivity::class.java)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }
    override fun onActivityCreated() {
        setupToolbar()
        confirm_btn.setOnClickListener {
            finish()
        }

        image_view.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_PICK
            startActivityForResult(intent, 1001)
        }
    }

    private var mRepositories = SampleRepositories()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Logger.d("requestCode : $requestCode")
        Logger.d("resultCode : $resultCode")
        val file = File(data?.data?.path)

        Logger.d(file.absolutePath)
        Logger.d(data?.data.toString())
        Logger.d(data?.data?.let { getRealPathFromURI(contentResolver, it) })

        var test = File(data?.data?.let { getRealPathFromURI(contentResolver, it) })
        mRepositories.singUp("abc22@abc", "dongho2", "haha2", "1234", "123123", test)
//        mRepositories.userUpdateImage(
//            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1SWQiOjExNSwiaWF0IjoxNTcwMzUxOTAwLCJleHAiOjE1NzA0MzgzMDAsImlzcyI6ImV4cyIsInN1YiI6ImFjY2VzcyJ9.aWgdfRuYjTKpgWeb_gjIScvMEVy9z-eQqnQY4TJtEe4",
//            test)
    }

    private fun getRealPathFromURI(contentResolver: ContentResolver, contentURI: Uri): String? {
        val result: String?
        val cursor = contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) {
            result = contentURI.path
        } else {
            cursor.moveToFirst()
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result
    }
}