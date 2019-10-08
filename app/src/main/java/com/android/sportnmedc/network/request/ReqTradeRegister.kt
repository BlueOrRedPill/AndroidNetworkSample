package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Trade - Setting trade

{
    "userId" : 1234,
    "token" : "token",
    "giveCards" : [
                    {123}, ...
                   ],
    "needCards" : [
                    {123}, ...
                   ]
}
*/
data class ReqTradeRegister(@Expose var userId: Long, @Expose var token: String, @Expose var giveCards: List<Long>, @Expose var needCards: List<Long>)