package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
User - Update user password

{
    "token" : "token",
    "userId" : 5678,
    "password" : "1234"
}
*/
data class ReqUserUpdatePassword(@Expose var token: String, @Expose var userId: Long, @Expose var password:String)