package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Buy item

{
    "userId" : 1234,
    "token" : "token",
    "marketId" : 1234,
    "count" : 10,
    "price" : 123
}
*/
data class ReqMarketBuy(@Expose var userId: Long, @Expose var token: String, @Expose var marketId: Long, @Expose var count: Int, @Expose var price: Int)