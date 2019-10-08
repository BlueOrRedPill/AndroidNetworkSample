package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Trade - Confirm trade

{
    "userId" : 1234,
    "token" : "token",
    "tradeId" : 1234
}
*/
data class ReqTradeConfirm(@Expose var userId: Long, @Expose var token: String, @Expose var tradeId:Long)