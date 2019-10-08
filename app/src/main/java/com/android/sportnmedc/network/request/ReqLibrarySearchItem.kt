package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Library - Get card search list

{
    "userId" : 1234,
    "cardName" : "name",
    "resultCount" : 20,
    "order" : "asc",
    "lastCardId" : 1234
}
*/
data class ReqLibrarySearchItem(@Expose var userId: Long, @Expose var cardName: String, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastCardId: Long)