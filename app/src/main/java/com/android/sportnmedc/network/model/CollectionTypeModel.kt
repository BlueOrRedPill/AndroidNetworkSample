package com.android.sportnmedc.network.model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.reflect.TypeToken

data class CollectionTypeModel(@Expose val sportsType: Int, @Expose val sportsName: String, @Expose val itemCount: Int, @Expose val itemMaxCount: Int) {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(s: String): CollectionTypeModel {
            return Gson().fromJson<CollectionTypeModel>(s, CollectionTypeModel::class.java)
        }

        fun fromJson(jsonObject: JsonObject): CollectionTypeModel {
            return fromJson(jsonObject.toString())
        }

        fun fromJsonList(s: String): List<CollectionTypeModel>? {
            val listType = object : TypeToken<List<CollectionTypeModel>>() {}.type
            return Gson().fromJson<List<CollectionTypeModel>>(s, listType)
        }

        fun fromJsonList(jsonObject: JsonObject): List<CollectionTypeModel>? {
            return fromJsonList(jsonObject.toString())
        }
    }
}