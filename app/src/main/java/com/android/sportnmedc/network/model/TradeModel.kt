package com.android.sportnmedc.network.model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken

data class TradeModel(@Expose val tradeId:Long, @Expose val profile:UserModel, @Expose val giveCardList:List<CardModel>, @Expose val needCardList:List<CardModel>, @Expose val timestamp:Long) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(s: String): TradeModel {
            return Gson().fromJson<TradeModel>(s, TradeModel::class.java)
        }

        fun fromJson(jsonObject: JsonObject): TradeModel {
            return fromJson(jsonObject.toString())
        }

        fun fromJsonList(s: String): List<TradeModel>? {
            val listType = object : TypeToken<List<TradeModel>>() {}.type
            return Gson().fromJson<List<TradeModel>>(s, listType)
        }

        fun fromJsonList(jsonObject: JsonObject): List<TradeModel>? {
            return fromJsonList(jsonObject.toString())
        }
    }
}