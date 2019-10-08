package com.android.sportnmedc.network.request

import com.google.gson.Gson
import com.google.gson.annotations.Expose

data class ReqPost (@Expose var userId: Long) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}