package com.android.sportnmedc.network

import com.android.sportnmedc.network.request.*
import com.android.sportnmedc.network.response.ResAuthLogin
import com.google.gson.JsonObject
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


class SampleRepositories {
    private val networkClient = NetworkClient.getInstance()

    fun singUp(email: String, userName: String, userBio: String,
               password: String, secondPassword: String, file: File) {
        val fileBody = file.toString().toRequestBody("image/*".toMediaTypeOrNull())
        val filePart = MultipartBody.Part.createFormData("userImage", file.name, fileBody)
        val emailBody = email.toRequestBody("text/plain".toMediaTypeOrNull())
        val passwordBody = password.toRequestBody("text/plain".toMediaTypeOrNull())
        val userNameBody = userName.toRequestBody("text/plain".toMediaTypeOrNull())
        val userBioBody = userBio.toRequestBody("text/plain".toMediaTypeOrNull())
        val secondPasswordBody = secondPassword.toRequestBody("text/plain".toMediaTypeOrNull())

        networkClient.api.authSignUp(filePart, emailBody, userNameBody, userBioBody, passwordBody, secondPasswordBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                }, { throwable ->
                    //TODO ERROR
                })
    }

    fun login(email: String, password: String) {
        networkClient.api.authLogin(ReqAuthLogin(email, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccess()) {
                    //TODO Success
                } else {
                    //TODO Fail
                }
            }, { throwable ->
                Logger.d(throwable.message)
                //TODO ERROR
            })
    }

    fun walletTransactionList(userId: Long, resultCount: Int, order: String, lastTransactionId: Long) {
        networkClient.api.walletTransactionList(ReqWalletTransactionList(userId, resultCount, order, lastTransactionId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun walletTransactionDetail(userId: Long, lastTransactionId: Long) {
        networkClient.api.walletTransactionDetail(ReqWalletTransactionDetail(userId, lastTransactionId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun walletBuyCoin(userId: Long, token: String, buyExs: Int, code: String) {
        networkClient.api.walletBuyCoin(ReqWalletBuyCoin(userId, token, buyExs, code))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun walletSendCoin(token: String, fromAddress: String, toAddress: String, sendExs: Int) {
        networkClient.api.walletSendCoin(ReqWalletSendCoin(token, fromAddress, toAddress, sendExs))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun userProfile(token: String, targetUserId: Long) {
        networkClient.api.userProfile(token, targetUserId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                    Logger.json(response.toString())
                },
                { throwable ->
                    throwable.message?.let { Logger.e(it) }
                    //TODO ERROR MESSAGE
                })
    }

    fun userUpdateProfile(token: String, userId: Long, name: String, image: String) {
        networkClient.api.userUpdateProfile(ReqUserUpdateProfile(token, userId, name, image))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun userUpdatePassword(token: String, userId: Long, password: String) {
        networkClient.api.userUpdatePassword(ReqUserUpdatePassword(token, userId, password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun userUpdateImage(token: String, file: File) {
        val fileBody = file.toString().toRequestBody("image/*".toMediaTypeOrNull())
        val filePart = MultipartBody.Part.createFormData("userImage", file.name, fileBody)

        networkClient.api.userUpdateImage(token, filePart).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { hrowable ->
                    //TODO ERROR
                })
    }

//    fun userList(token: String, userId: Long, password: String) {
//        networkClient.api.userList(JsonObject())
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { response ->
//                if (response.isSuccess()) {
//                    //TODO Success
//                } else {
//                    //TODO Fail
//                }
//
//                },
//                { throwable ->
//                    //TODO ERROR MESSAGE
//                })
//    }

    fun leaderboard(userId: Long, resultCount: Int, order: String, lastUserId: Long) {
        networkClient.api
            .leaderboard(ReqLeaderboard(userId, resultCount, order, lastUserId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun libraryItemList(userId: Long, resultCount: Int, order: String, lastCardId: Long) {
        networkClient.api
            .libraryItemList(ReqLibraryItemList(userId, resultCount, order, lastCardId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun libraryItemDetail(userId: Long, cardId: Long) {
        networkClient.api.libraryItemDetail(ReqLibraryItemDetail(userId, cardId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun librarySalesItem(userId: Long, resultCount: Int, order: String, lastMarketId: Long) {
        networkClient.api
            .librarySalesItemList(ReqLibrarySalesItemList(userId, resultCount, order, lastMarketId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun librarySearchItem(userId: Long, cardName: String, resultCount: Int, order: String, lastCardId: Long) {
        networkClient.api.librarySearchItem(ReqLibrarySearchItem(userId, cardName, resultCount, order, lastCardId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun libraryItemTransactionList(userId: Long, cardId: Long, resultCount: Int, order: String, lastTransactionId: Long) {
        networkClient.api.libraryItemTransactionList(ReqLibraryItemTransactionList(userId, cardId, resultCount, order, lastTransactionId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun libraryCollectionList(userId: Long, sportsType: String, resultCount: Int, order: String, lastCardId: Long) {
        networkClient.api.libraryCollectionList(ReqLibraryCollectionList(userId, sportsType, resultCount, order, lastCardId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun libraryCollectionType(sourceUserId: Long, targetUserId: Long) {
        networkClient.api
            .libraryCollectionType(ReqLibraryCollectionType(sourceUserId, targetUserId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketBuy(userId: Long, token: String, marketId: Long, count: Int, price: Int) {
        networkClient.api.marketBuy(ReqMarketBuy(userId, token, marketId, count, price))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketCancel(userId: Long, token: String, marketId: Long) {
        networkClient.api.marketCancel(ReqMarketCancel(userId, token, marketId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketRegister(userId: Long, token: String, cardId: Long, count: Int, price: Int) {
        networkClient.api.marketRegister(ReqMarketRegister(userId, token, cardId, count, price))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketSalesList(userId: Long, sportsType: String, resultCount: Int, order: String, lastMarketId: Long) {
        networkClient.api
            .marketSales(ReqMarketSaleList(userId, sportsType, resultCount, order, lastMarketId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketSaleDetail(userId: Long, marketId: Long) {
        networkClient.api.marketSaleDetail(ReqMarketSaleDetail(userId, marketId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun marketNewArrivalList(userId: Long, resultCount: Int, order: String, lastMarketId: Long) {
        networkClient.api
            .marketNewArrival(ReqMarketNewArrivalList(userId, resultCount, order, lastMarketId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun tradeList(userId: Long, resultCount: Int, order: String, lastTradeId: Long) {
        networkClient.api.tradeList(ReqTradeList(userId, resultCount, order, lastTradeId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun tradeSearch(userId: Long, search: String, searchType: String, resultCount: Int, order: String, lastTradeId: Long) {
        networkClient.api.tradeSearch(ReqTradeSearchList(userId, search, searchType, resultCount, order, lastTradeId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun tradeRegister(userId: Long, token: String, giveCards: List<Long>, needCards: List<Long>) {
        networkClient.api.tradeRegister(ReqTradeRegister(userId, token, giveCards, needCards))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun tradeCancel(userId: Long, token: String, tradeId: Long) {
        networkClient.api.tradeCancel(ReqTradeCancel(userId, token, tradeId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun tradeConfirm(userId: Long, token: String, tradeId: Long) {
        networkClient.api.tradeConfirm(ReqTradeConfirm(userId, token, tradeId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun notificationList(userId: Long, resultCount: Int, order: String, lastId: Long) {
        networkClient.api.notificationList(ReqNotificationList(userId, resultCount, order, lastId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }

    fun promotionList(userId: Long, resultCount: Int, order: String, lastId: Long) {
        networkClient.api.promotionList(ReqPromotionList(userId, resultCount, order, lastId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    if (response.isSuccess()) {
                        //TODO Success
                    } else {
                        //TODO Fail
                    }
                },
                { throwable ->
                    //TODO ERROR MESSAGE
                })
    }
}