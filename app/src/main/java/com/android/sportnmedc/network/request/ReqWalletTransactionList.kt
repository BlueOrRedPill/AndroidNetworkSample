package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Wallet - Get transaction list

{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastTransactionId" : 1568797659 (or transactionHash)
}
*/
data class ReqWalletTransactionList(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastTransactionId: Long)