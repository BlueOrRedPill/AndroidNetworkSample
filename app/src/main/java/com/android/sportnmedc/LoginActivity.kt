package com.android.sportnmedc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.sportnmedc.helpers.ToolbarHelper
import com.android.sportnmedc.network.SampleRepositories
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(R.layout.activity_login), ToolbarHelper {
    private var repositories = SampleRepositories()

    override fun hasBackMenu(): Boolean = true
    override fun toolbarTitle(): String? = ""

    companion object {
        fun newIntent(mActivity: AppCompatActivity): Intent {
            val intent = Intent(mActivity, LoginActivity::class.java)
            return intent
        }
    }

    override fun initMenuEvent(mToolbar: Toolbar?) {

    }

    override fun onActivityCreated() {
        setupToolbar()
        confirm_btn.setOnClickListener {
            startActivity(HomeActivity.newIntent(mActivity))
            finish()
        }
        register_btn.setOnClickListener {
            startActivity(RegisterActivity.newIntent(mActivity))
        }

//        repositories.login("11127155mino74444@hanafos.com", "haha")
        repositories.login("abcd@gmail.com", "1234")
//        repositories.userProfile(
//            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1SWQiOjExNSwiaWF0IjoxNTcwMzUxOTAwLCJleHAiOjE1NzA0MzgzMDAsImlzcyI6ImV4cyIsInN1YiI6ImFjY2VzcyJ9.aWgdfRuYjTKpgWeb_gjIScvMEVy9z-eQqnQY4TJtEe4"
//            , 115)
//        repositories.getPosts(1)
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET),
//            10
//        )
    }
}