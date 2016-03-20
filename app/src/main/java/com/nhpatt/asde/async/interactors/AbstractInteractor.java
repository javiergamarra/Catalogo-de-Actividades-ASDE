package com.nhpatt.asde.async.interactors;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.nhpatt.asde.async.RetrofitAPI;

import retrofit2.Retrofit;


public abstract class AbstractInteractor {

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
