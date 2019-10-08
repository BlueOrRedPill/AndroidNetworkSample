package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Notification - Get notification list

{
    "userId" : 1234,
    "resultCount" : 20,
    "order" : "asc",
    "lastId" : 1234
}
*/
data class ReqNotificationList(@Expose var userId: Long, @Expose var resultCount: Int, @Expose var order: String, @Expose var lastId: Long)