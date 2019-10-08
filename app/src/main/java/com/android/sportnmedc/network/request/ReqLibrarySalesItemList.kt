package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Library - Get card sale list
{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastMarketId" : 1234
}
*/
data class ReqLibrarySalesItemList(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastMarketId: Long)