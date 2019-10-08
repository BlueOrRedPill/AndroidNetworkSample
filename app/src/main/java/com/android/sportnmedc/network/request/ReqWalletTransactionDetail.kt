package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Wallet - Get transaction detail

{
    "userId" : 1234,
    "transactionId" : 1568797659
}
*/
data class ReqWalletTransactionDetail(@Expose var userId: Long, @Expose var transactionId: Long)