package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Trade - Cancel trade

{
    "userId" : 1234,
    "token" : "token",
    "tradeId" : 1234
}
*/
data class ReqTradeCancel(@Expose var userId: Long, @Expose var token: String, @Expose var tradeId:Long)