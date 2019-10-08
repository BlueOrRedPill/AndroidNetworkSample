package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Leaderboard - Get ranking list

{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastUserId" : 1234
}
*/
data class ReqLeaderboard(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastUserId: Long)