package com.nhpatt.asde.async;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Javier Gamarra
 */
public class RetrofitAPI {

    public static Retrofit getApiary() {
        return new Retrofit.Builder()
                .baseUrl("http://private-8b0f5-catalogodeactividadesasde.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
