package com.android.sportnmedc.network;

import com.android.sportnmedc.network.model.CardModel;
import com.android.sportnmedc.network.request.ReqAuthLogin;
import com.android.sportnmedc.network.request.ReqLeaderboard;
import com.android.sportnmedc.network.request.ReqLibraryCollectionList;
import com.android.sportnmedc.network.request.ReqLibraryCollectionType;
import com.android.sportnmedc.network.request.ReqLibraryItemDetail;
import com.android.sportnmedc.network.request.ReqLibraryItemList;
import com.android.sportnmedc.network.request.ReqLibraryItemTransactionList;
import com.android.sportnmedc.network.request.ReqLibrarySalesItemList;
import com.android.sportnmedc.network.request.ReqLibrarySearchItem;
import com.android.sportnmedc.network.request.ReqMarketBuy;
import com.android.sportnmedc.network.request.ReqMarketCancel;
import com.android.sportnmedc.network.request.ReqMarketNewArrivalList;
import com.android.sportnmedc.network.request.ReqMarketRegister;
import com.android.sportnmedc.network.request.ReqMarketSaleDetail;
import com.android.sportnmedc.network.request.ReqMarketSaleList;
import com.android.sportnmedc.network.request.ReqNotificationList;
import com.android.sportnmedc.network.request.ReqPromotionList;
import com.android.sportnmedc.network.request.ReqTradeCancel;
import com.android.sportnmedc.network.request.ReqTradeConfirm;
import com.android.sportnmedc.network.request.ReqTradeList;
import com.android.sportnmedc.network.request.ReqTradeRegister;
import com.android.sportnmedc.network.request.ReqTradeSearchList;
import com.android.sportnmedc.network.request.ReqUserUpdatePassword;
import com.android.sportnmedc.network.request.ReqUserUpdateProfile;
import com.android.sportnmedc.network.request.ReqWalletBuyCoin;
import com.android.sportnmedc.network.request.ReqWalletSendCoin;
import com.android.sportnmedc.network.request.ReqWalletTransactionDetail;
import com.android.sportnmedc.network.request.ReqWalletTransactionList;
import com.android.sportnmedc.network.response.ResAuthLogin;
import com.android.sportnmedc.network.response.ResAuthSignup;
import com.android.sportnmedc.network.response.ResLeaderboard;
import com.android.sportnmedc.network.response.ResLibraryCollectionList;
import com.android.sportnmedc.network.response.ResLibraryCollectionType;
import com.android.sportnmedc.network.response.ResLibraryItemDetail;
import com.android.sportnmedc.network.response.ResLibraryItemList;
import com.android.sportnmedc.network.response.ResLibraryItemTransactionList;
import com.android.sportnmedc.network.response.ResLibrarySalesItemList;
import com.android.sportnmedc.network.response.ResLibrarySearchItem;
import com.android.sportnmedc.network.response.ResMarketBuy;
import com.android.sportnmedc.network.response.ResMarketCancel;
import com.android.sportnmedc.network.response.ResMarketNewArrivals;
import com.android.sportnmedc.network.response.ResMarketRegister;
import com.android.sportnmedc.network.response.ResMarketSaleDetail;
import com.android.sportnmedc.network.response.ResMarketSales;
import com.android.sportnmedc.network.response.ResNotificationList;
import com.android.sportnmedc.network.response.ResPromotionList;
import com.android.sportnmedc.network.response.ResTradeCancel;
import com.android.sportnmedc.network.response.ResTradeConfirm;
import com.android.sportnmedc.network.response.ResTradeList;
import com.android.sportnmedc.network.response.ResTradeRegister;
import com.android.sportnmedc.network.response.ResTradeSearch;
import com.android.sportnmedc.network.response.ResUserProfile;
import com.android.sportnmedc.network.response.ResUserUpdateImage;
import com.android.sportnmedc.network.response.ResUserUpdatePassword;
import com.android.sportnmedc.network.response.ResUserUpdateProfile;
import com.android.sportnmedc.network.response.ResWalletBuyCoin;
import com.android.sportnmedc.network.response.ResWalletSendCoin;
import com.android.sportnmedc.network.response.ResWalletTransactionDetail;
import com.android.sportnmedc.network.response.ResWalletTransactionList;
import com.google.gson.JsonObject;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class SampleRepositories_Java {
    private NetworkClient networkClient = NetworkClient.getInstance();

    public void singup(String email, String userName, String userBio, String password, String secondPassword, File file) {
        RequestBody fileBody = RequestBody.create(file, MediaType.parse("image/*"));
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("userImage", file.getName(), fileBody);
        RequestBody emailBody = RequestBody.create(email, MediaType.parse("text/plain"));
        RequestBody passwordBody = RequestBody.create(password, MediaType.parse("text/plain"));
        RequestBody userNameBody = RequestBody.create(userName, MediaType.parse("text/plain"));
        RequestBody userBioBody = RequestBody.create(userBio, MediaType.parse("text/plain"));
        RequestBody secondPasswordBody = RequestBody.create(secondPassword, MediaType.parse("text/plain"));

        networkClient.getApi().authSignUp(filePart, emailBody, userNameBody, userBioBody, passwordBody, secondPasswordBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResAuthSignup>() {
                    @Override
                    public void accept(ResAuthSignup response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void login(String email, String password) {
//        networkClient.getApi().authLogin(new ReqAuthLogin(email, password))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ResAuthLogin>() {
//                    @Override
//                    public void accept(ResAuthLogin response) throws Exception {
//                        if(response.isSuccess()) {
//                            //TODO Success
//                        } else {
//                            //TODO Fail
//                        }
//                        Logger.json(response.toString());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Logger.e(throwable.getMessage());
//                    }
//                });
    }

    public void walletGetTransactions(long userId, int resultCount, String order, long lastTransactionId) {
        networkClient.getApi().walletTransactionList(new ReqWalletTransactionList(userId, resultCount, order, lastTransactionId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResWalletTransactionList>() {
                    @Override
                    public void accept(ResWalletTransactionList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void walletGetTransactionDetail(long userId, long lastTransactionId) {
        networkClient.getApi().walletTransactionDetail(new ReqWalletTransactionDetail(userId, lastTransactionId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResWalletTransactionDetail>() {
                    @Override
                    public void accept(ResWalletTransactionDetail response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void walletIssueCoin(long userId, String token, int buyExs, String code) {
        networkClient.getApi().walletBuyCoin(new ReqWalletBuyCoin(userId, token, buyExs, code))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResWalletBuyCoin>() {
                    @Override
                    public void accept(ResWalletBuyCoin response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void walletSendCoin(String token, String fromAddress, String toAddress, int sendExs) {
        networkClient.getApi().walletSendCoin(new ReqWalletSendCoin(token, fromAddress, toAddress, sendExs))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResWalletSendCoin>() {
                    @Override
                    public void accept(ResWalletSendCoin response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void userProfile(String token, long targetUserId) {
        networkClient.getApi().userProfile(token, targetUserId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResUserProfile>() {
                    @Override
                    public void accept(ResUserProfile response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void userUpdateImage(String token, File file) {
        RequestBody fileBody = RequestBody.create(file, MediaType.parse("image/*"));
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("userImage", file.getName(), fileBody);

        networkClient.getApi().userUpdateImage(token, filePart).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResUserUpdateImage>() {
                    @Override
                    public void accept(ResUserUpdateImage response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void userUpdateProfile(String token, long userId, String name, String image) {
        networkClient.getApi().userUpdateProfile(new ReqUserUpdateProfile(token, userId, name, image))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResUserUpdateProfile>() {
                    @Override
                    public void accept(ResUserUpdateProfile response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void userUpdatePassword(String token, long userId, String password) {
        networkClient.getApi().userUpdatePassword(new ReqUserUpdatePassword(token, userId, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResUserUpdatePassword>() {
                    @Override
                    public void accept(ResUserUpdatePassword response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void userList(String token, long userId, String password) {
        networkClient.getApi().userList(new JsonObject())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JsonObject>() {
                    @Override
                    public void accept(JsonObject response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void leaderboardRankingList(long userId, int resultCount, String order, long lastUserId) {
        networkClient.getApi().leaderboard(new ReqLeaderboard(userId, resultCount, order, lastUserId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLeaderboard>() {
                    @Override
                    public void accept(ResLeaderboard response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCardAll(long userId, int resultCount, String order, long lastCardId) {
        networkClient.getApi().libraryItemList(new ReqLibraryItemList(userId, resultCount, order, lastCardId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibraryItemList>() {
                    @Override
                    public void accept(ResLibraryItemList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCardDetail(long userId, long cardId) {
        networkClient.getApi().libraryItemDetail(new ReqLibraryItemDetail(userId, cardId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibraryItemDetail>() {
                    @Override
                    public void accept(ResLibraryItemDetail response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCardSales(long userId, int resultCount, String order, long lastMarketId) {
        networkClient.getApi().librarySalesItemList(new ReqLibrarySalesItemList(userId, resultCount, order, lastMarketId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibrarySalesItemList>() {
                    @Override
                    public void accept(ResLibrarySalesItemList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCardSearch(long userId, String cardName, int resultCount, String order, long lastCardId) {
        networkClient.getApi().librarySearchItem(new ReqLibrarySearchItem(userId, cardName, resultCount, order, lastCardId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibrarySearchItem>() {
                    @Override
                    public void accept(ResLibrarySearchItem response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCardTransactions(long userId, long cardId, int resultCount, String order, long lastTransactionId) {
        networkClient.getApi().libraryItemTransactionList(new ReqLibraryItemTransactionList(userId, cardId, resultCount, order, lastTransactionId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibraryItemTransactionList>() {
                    @Override
                    public void accept(ResLibraryItemTransactionList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCollections(long userId, String sportsType, int resultCount, String order, long lastCardId) {
        networkClient.getApi().libraryCollectionList(new ReqLibraryCollectionList(userId, sportsType, resultCount, order, lastCardId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibraryCollectionList>() {
                    @Override
                    public void accept(ResLibraryCollectionList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void libraryCollectionType(long sourceUserId, long targetUserId) {
        networkClient.getApi().libraryCollectionType(new ReqLibraryCollectionType(sourceUserId, targetUserId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResLibraryCollectionType>() {
                    @Override
                    public void accept(ResLibraryCollectionType response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketBuy(long userId, String token, long marketId, int count, int price) {
        networkClient.getApi().marketBuy(new ReqMarketBuy(userId, token, marketId, count, price))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketBuy>() {
                    @Override
                    public void accept(ResMarketBuy response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketCancel(long userId, String token, long marketId) {
        networkClient.getApi().marketCancel(new ReqMarketCancel(userId, token, marketId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketCancel>() {
                    @Override
                    public void accept(ResMarketCancel response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketSet(long userId, String token, long cardId, int count, int price) {
        networkClient.getApi().marketRegister(new ReqMarketRegister(userId, token, cardId, count, price))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketRegister>() {
                    @Override
                    public void accept(ResMarketRegister response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketSales(long userId, String sportsType, int resultCount, String order, long lastMarketId) {
        networkClient.getApi().marketSales(new ReqMarketSaleList(userId, sportsType, resultCount, order, lastMarketId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketSales>() {
                    @Override
                    public void accept(ResMarketSales response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketSaleDetail(long userId, long marketId) {
        networkClient.getApi().marketSaleDetail(new ReqMarketSaleDetail(userId, marketId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketSaleDetail>() {
                    @Override
                    public void accept(ResMarketSaleDetail response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void marketNewArrival(long userId, int resultCount, String order, long lastMarketId) {
        networkClient.getApi().marketNewArrival(new ReqMarketNewArrivalList(userId, resultCount, order, lastMarketId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResMarketNewArrivals>() {
                    @Override
                    public void accept(ResMarketNewArrivals response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void trades(long userId, int resultCount, String order, long lastTradeId) {
        networkClient.getApi().tradeList(new ReqTradeList(userId, resultCount, order, lastTradeId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResTradeList>() {
                    @Override
                    public void accept(ResTradeList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void tradeSearch(long userId, String search, String searchType, int resultCount, String order, long lastTradeId) {
        networkClient.getApi().tradeSearch(new ReqTradeSearchList(userId, search, searchType, resultCount, order, lastTradeId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResTradeSearch>() {
                    @Override
                    public void accept(ResTradeSearch response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void tradeSet(long userId, String token, List<Long> giveCards, List<Long> needCards) {
        networkClient.getApi().tradeRegister(new ReqTradeRegister(userId, token, giveCards, needCards))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResTradeRegister>() {
                    @Override
                    public void accept(ResTradeRegister response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void tradeCancel(long userId, String token, long tradeId) {
        networkClient.getApi().tradeCancel(new ReqTradeCancel(userId, token, tradeId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResTradeCancel>() {
                    @Override
                    public void accept(ResTradeCancel response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void tradeConfirm(long userId, String token, long tradeId) {
        networkClient.getApi().tradeConfirm(new ReqTradeConfirm(userId, token, tradeId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResTradeConfirm>() {
                    @Override
                    public void accept(ResTradeConfirm response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void notifications(long userId, int resultCount, String order, long lastId) {
        networkClient.getApi().notificationList(new ReqNotificationList(userId, resultCount, order, lastId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResNotificationList>() {
                    @Override
                    public void accept(ResNotificationList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }

    public void promotions(long userId, int resultCount, String order, long lastId) {
        networkClient.getApi().promotionList(new ReqPromotionList(userId, resultCount, order, lastId))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResPromotionList>() {
                    @Override
                    public void accept(ResPromotionList response) throws Exception {
                        Logger.json(response.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });
    }
}
