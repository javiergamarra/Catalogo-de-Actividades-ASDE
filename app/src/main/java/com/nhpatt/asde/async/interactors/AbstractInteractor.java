package com.nhpatt.asde.async.interactors;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.nhpatt.asde.async.RetrofitAPI;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public abstract class AbstractInteractor {

    <T> Observable.Transformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    protected Retrofit getApiary() {
        return RetrofitAPI.getApiary();
    }

    public boolean checkConnection(Context context) {
        ConnectivityManager manager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
