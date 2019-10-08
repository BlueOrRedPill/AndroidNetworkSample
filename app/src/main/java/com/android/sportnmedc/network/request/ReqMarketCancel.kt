package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Cancel item

{
    "userId" : 1234,
    "token" : "token",
    "marketId" : 1234
}
*/
data class ReqMarketCancel(@Expose var userId: Long, @Expose var token: String, @Expose var marketId: Long)