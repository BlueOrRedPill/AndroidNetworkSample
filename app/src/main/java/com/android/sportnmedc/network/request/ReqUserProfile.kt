package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
User - Get user profile

{
    "sourceUserId" : 1234,
    "targetUserId" : 5678
}
*/
data class ReqUserProfile(@Expose var sourceUserId: Long, @Expose var targetUserId: Long)