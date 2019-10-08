package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Wallet - Send coin

{
    "token" : "token",
    "fromAddress" : "0x4B8ac634d724872748310f83b4D9830E468Fc1c1", (or fromUserId)
    "toAddress" : "0x4B8ac634d724872748310f83b4D9830E468Fc1c1", (or toUserId)
    "sendExs" : 20
}
*/
data class ReqWalletSendCoin(@Expose var token: String, @Expose var fromAddress: String, @Expose var toAddress: String, @Expose var sendExs: Int)