package com.android.sportnmedc.network

import com.android.sportnmedc.network.model.CardModel
import com.android.sportnmedc.network.request.*
import com.android.sportnmedc.network.response.*
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface NetworkApi {
    //AUTH
    @Multipart
    @POST("/api/v1.1/auth/signup")
    fun authSignUp(
        @Part userImage: MultipartBody.Part,
        @Part("email") email: RequestBody,
        @Part("userName") userName: RequestBody,
        @Part("userBio") userBio: RequestBody,
        @Part("password") password: RequestBody,
        @Part("secondPassword") secondPassword: RequestBody
    ): Single<ResAuthSignup>    // SignUp

    @POST("/api/v1.1/auth/login")
    fun authLogin(@Body req: ReqAuthLogin): Single<ResAuthLogin>  // Login


    //WALLET
    @POST("/api/v1.1/wallet/transaction")
    fun walletTransactionList(@Body req: ReqWalletTransactionList): Single<ResWalletTransactionList>  // Wallet Transaction List

    @POST("/api/v1.1/wallet/transaction/detail")
    fun walletTransactionDetail(@Body req: ReqWalletTransactionDetail): Single<ResWalletTransactionDetail>  // Transaction Detail

    @POST("/api/v1.1/wallet/send")
    fun walletSendCoin(@Body req: ReqWalletSendCoin): Single<ResWalletSendCoin>  // Send EXS

    @POST("/api/v1.1/wallet/buy")
    fun walletBuyCoin(@Body req: ReqWalletBuyCoin): Single<ResWalletBuyCoin>  // Buy EXS


    //USER
    @POST("/api/v1.1/user/{targetUid}/detailprofile")
    fun userProfile(@Header("x-access-token") token: String, @Path("targetUid") targetUid:Long): Single<ResUserProfile>  // User Profile Detail

    @POST("/api/v1.1/user/update/profile")
    fun userUpdateProfile(@Body req: ReqUserUpdateProfile): Single<ResUserUpdateProfile>  // Update Profile

    @POST("/api/v1.1/user/update/password")
    fun userUpdatePassword(@Body req: ReqUserUpdatePassword): Single<ResUserUpdatePassword>  // Update Password

    @Multipart
    @POST("/api/v1.1/api/v1.1/user/setuserimage")
    fun userUpdateImage(
        @Header("x-access-token") token: String,
        @Part userImage: MultipartBody.Part
    ): Single<ResUserUpdateImage>   // Update Image

    @POST("/api/v1.1/user")
    fun userList(@Body req: JsonObject): Single<JsonObject>  // User List


    //LEADER BOARD
    @POST("/api/v1.1/leaderboard")
    fun leaderboard(@Body req: ReqLeaderboard): Single<ResLeaderboard>  // LeaderBoard


    //LIBRARY
    @POST("/api/v1.1/library/collection/type")
    fun libraryCollectionType(@Body req: ReqLibraryCollectionType): Single<ResLibraryCollectionType>  // Collection Type

    @POST("/api/v1.1/library/collection")
    fun libraryCollectionList(@Body req: ReqLibraryCollectionList): Single<ResLibraryCollectionList>  // Collection List

    @POST("/api/v1.1/library/card/detail")
    fun libraryItemDetail(@Body req: ReqLibraryItemDetail): Single<ResLibraryItemDetail>  // Item Detail

    @POST("/api/v1.1/library/card/transactions")
    fun libraryItemTransactionList(@Body req: ReqLibraryItemTransactionList): Single<ResLibraryItemTransactionList>  // Item Transaction List

    @POST("/api/v1.1/library/card/sale")
    fun librarySalesItemList(@Body req: ReqLibrarySalesItemList): Single<ResLibrarySalesItemList>  // Market Sales List (My)

    @POST("/api/v1.1/library/card/all")
    fun libraryItemList(@Body req: ReqLibraryItemList): Single<ResLibraryItemList>  // All Item List

    @POST("/api/v1.1/library/card/search")
    fun librarySearchItem(@Body req: ReqLibrarySearchItem): Single<ResLibrarySearchItem>  // Search Item


    //MARKET
    @POST("/api/v1.1/market")
    fun marketSales(@Body req: ReqMarketSaleList): Single<ResMarketSales>  // Market Sales List

    @POST("/api/v1.1/market/register")
    fun marketRegister(@Body req: ReqMarketRegister): Single<ResMarketRegister>  // Market Register

    @POST("/api/v1.1/market/cancel")
    fun marketCancel(@Body req: ReqMarketCancel): Single<ResMarketCancel>  // Market Cancel

    @POST("/api/v1.1/market/buy")
    fun marketBuy(@Body req: ReqMarketBuy): Single<ResMarketBuy>  // Market Buy

    @POST("/api/v1.1/market/newarrival")
    fun marketNewArrival(@Body req: ReqMarketNewArrivalList): Single<ResMarketNewArrivals>  // New Arrival List

    @POST("/api/v1.1/market/detail")
    fun marketSaleDetail(@Body req: ReqMarketSaleDetail): Single<ResMarketSaleDetail>  // Sales Item Detail


    //TRADE
    @POST("/api/v1.1/trade")
    fun tradeList(@Body req: ReqTradeList): Single<ResTradeList>  // Trade List

    @POST("/api/v1.1/trade/register")
    fun tradeRegister(@Body req: ReqTradeRegister): Single<ResTradeRegister>  // Trade Register

    @POST("/api/v1.1/trade/cancel")
    fun tradeCancel(@Body req: ReqTradeCancel): Single<ResTradeCancel>  // Trade Cancel

    @POST("/api/v1.1/trade/confirm")
    fun tradeConfirm(@Body req: ReqTradeConfirm): Single<ResTradeConfirm>  // Trade Confirm

    @POST("/api/v1.1/trade/search")
    fun tradeSearch(@Body req: ReqTradeSearchList): Single<ResTradeSearch>  // Search Trade List


    //NOTIFICATION
    @POST("/api/v1.1/notification")
    fun notificationList(@Body req: ReqNotificationList): Single<ResNotificationList>  // Notification List


    //PROMOTION
    @POST("/api/v1.1/promotion")
    fun promotionList(@Body req: ReqPromotionList): Single<ResPromotionList>  // Promotion List
}