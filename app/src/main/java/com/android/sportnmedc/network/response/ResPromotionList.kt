package com.android.sportnmedc.network.response

import com.android.sportnmedc.network.BaseData
import com.android.sportnmedc.network.BaseResponse
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class ResPromotionList(
    @SerializedName("data")
    override val result: BaseData,
    override val warnings: List<String>,
    override val status: Integer,
    override val provider: String
) : BaseResponse {

    override fun toString(): String {
        return Gson().toJson(this)
    }

    val data = result.data
}