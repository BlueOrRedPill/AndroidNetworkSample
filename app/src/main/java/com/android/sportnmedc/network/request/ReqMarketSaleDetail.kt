package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Market - Get sale detail

{
    "userId" : 1234,
    "marketId" : 1234
}
*/
data class ReqMarketSaleDetail(@Expose var userId: Long, @Expose var marketId: Long)