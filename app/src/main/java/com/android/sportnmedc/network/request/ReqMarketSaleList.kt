package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Get sale list

{
    "userId" : 1234,
    "sportsType" : "type",
    "resultCount" : 20,
    "order" : "asc",
    "lastMarketId" : 1234
}
*/
data class ReqMarketSaleList(@Expose var userId: Long, @Expose var sportsType: String, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastMarketId: Long)