package com.android.sportnmedc

import android.os.Handler

/**
 * Created by AndroidEB on 1/8/2018.
 */
class LandingActivity: BaseActivity(R.layout.activity_landing,0) {

    private val handler: Handler = Handler()
    private val runnable: Runnable =  Runnable {
        nextActivity()
        finish()
    }
    private var delay_time: Long = 0
    private var time = 1500L

    override fun onActivityCreated() {

    }

    override fun onResume() {
        super.onResume()
        delay_time = time
        handler.postDelayed(runnable, delay_time)
        time = System.currentTimeMillis()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
        time = delay_time - (System.currentTimeMillis() - time)
    }


    private fun nextActivity(){
        val startIntent = LoginActivity.newIntent(mActivity)
        if (intent.hasExtra("target")) {
            startIntent.putExtra("target", intent.getStringExtra("target"))
        }
        startActivity(startIntent)
    }
}