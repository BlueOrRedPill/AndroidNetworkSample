package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Trade - Get trade list

{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastTradeId" : 1234
}
*/
data class ReqTradeList(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastTradeId: Long)