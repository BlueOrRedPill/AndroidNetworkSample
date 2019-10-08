package com.android.sportnmedc.network.response

import com.android.sportnmedc.network.BaseData
import com.android.sportnmedc.network.BaseResponse
import com.android.sportnmedc.network.model.CardModel
import com.android.sportnmedc.network.model.TransactionModel
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Library - sale card list Response
 */
data class ResLibrarySalesItemList(
    @SerializedName("data")
    override val result: BaseData,
    override val warnings: List<String>,
    override val status: Integer,
    override val provider: String ) : BaseResponse {

    override fun toString(): String {
        return Gson().toJson(this)
    }

    val data: List<CardModel>?
        get() {
            return CardModel.fromJsonList(result.data)
        }
}