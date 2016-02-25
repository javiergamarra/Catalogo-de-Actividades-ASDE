package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Javier Gamarra
 */
public class SearchEventInteractor extends AbstractInteractor {
    @Override
    public void runOnBackground() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://private-8b0f5-catalogodeactividadesasde.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiaryService apiary = retrofit.create(ApiaryService.class);

        Call<Event> call = apiary.eventWithId("1");

        Event singleEvent = call.execute().body();

        EventBusUtil.post(singleEvent);


    }
}
