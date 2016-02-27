package com.nhpatt.asde.async;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Javier Gamarra
 */
public class RetrofitAPI {

    public static final String BASE_URL
            = "http://private-8b0f5-catalogodeactividadesasde.apiary-mock.com";

    public static Retrofit getApiary() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
