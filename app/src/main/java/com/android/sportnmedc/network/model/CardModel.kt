package com.android.sportnmedc.network.model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken

open class CardModel(@Expose val marketId: Long, @Expose val owner: UserModel, @Expose val cardId: Long, @Expose val cardName: String, @Expose val cardImage: String, @Expose val cardClass: String, @Expose val sportsType: Int, @Expose val sportsName: String, @Expose val editionName: String, @Expose val editionLogo: String, @Expose val country: String, @Expose val createTimestamp: Long, @Expose val fights: Int, @Expose val win: Int, @Expose val lose: Int, @Expose val draw: Int, @Expose val price: String, @Expose val count: Int) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(s: String): CardModel {
            return Gson().fromJson<CardModel>(s, CardModel::class.java)
        }

        fun fromJson(jsonObject: JsonObject): CardModel {
            return fromJson(jsonObject.toString())
        }

        fun fromJsonList(s: String): List<CardModel>? {
            val listType = object : TypeToken<List<CardModel>>() {}.type
            return Gson().fromJson<List<CardModel>>(s, listType)
        }

        fun fromJsonList(jsonObject: JsonObject): List<CardModel>? {
            return fromJsonList(jsonObject.toString())
        }
    }
}