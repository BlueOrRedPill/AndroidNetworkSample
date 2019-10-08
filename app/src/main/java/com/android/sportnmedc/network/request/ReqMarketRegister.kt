package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Setting sale card

{
    "userId" : 1234,
    "token" : "token",
    "cardId" : 1234,
    "count" : 10,
    "price" : 123
}
*/
data class ReqMarketRegister(@Expose var userId: Long, @Expose var token: String, @Expose var cardId: Long, @Expose var count: Int, @Expose var price: Int)