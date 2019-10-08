package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Get new arrival list

{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastMarketId" : 1234
}
*/
data class ReqMarketNewArrivalList(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastMarketId: Long)