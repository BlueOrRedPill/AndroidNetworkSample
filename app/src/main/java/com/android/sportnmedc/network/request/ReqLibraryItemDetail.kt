package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Library - Get card detail

{
    "userId" : 1234,
    "cardId" : 1234
}
*/
data class ReqLibraryItemDetail(@Expose var userId: Long, @Expose var cardId: Long)