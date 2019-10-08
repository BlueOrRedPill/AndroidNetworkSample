package com.android.sportnmedc.network.response

import com.android.sportnmedc.network.BaseData
import com.android.sportnmedc.network.BaseResponse
import com.android.sportnmedc.network.model.UserModel
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * Auth - login response data
 */
data class ResUserUpdateImage(
    @SerializedName("data")
    override val result: BaseData,
    override val warnings: List<String>,
    override val status: Integer,
    override val provider: String
) : BaseResponse {
    override fun toString(): String {
        return Gson().toJson(this)
    }

    val data: UserModel
        get() { //프로퍼티에 대한 getter() 커스텀 접근자
            return UserModel.fromJson(result.data)
        }
}