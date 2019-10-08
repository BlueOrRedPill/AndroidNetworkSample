package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
User - Update user profile

{
    "token" : 1234,
    "userId" : 5678,
    "name" : "dongho",
    "image" : "https://image.jpg"
}
*/
data class ReqUserUpdateProfile(@Expose var token: String, @Expose var userId: Long, @Expose var name: String, @Expose var image: String)