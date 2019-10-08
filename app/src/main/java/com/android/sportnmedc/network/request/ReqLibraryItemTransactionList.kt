package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Library - Get card transaction list

{
    "userId" : 1234,
    "cardId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastTransactionId" : 1234
}
*/
data class ReqLibraryItemTransactionList(@Expose var userId: Long, @Expose var cardId:Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastTransactionId: Long)