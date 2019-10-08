package com.android.sportnmedc.network.request

import com.google.gson.annotations.Expose

/*
Library - Get Collection type list

{
    "sourceUserId" : 1234,
    "targetUserId" : 5678
}
*/
data class ReqLibraryCollectionType(@Expose var sourceUserId: Long, @Expose var targetUserId: Long)