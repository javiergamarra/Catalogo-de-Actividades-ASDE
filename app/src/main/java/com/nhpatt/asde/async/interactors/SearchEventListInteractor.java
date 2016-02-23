package com.nhpatt.asde.async.interactors;

import android.util.Log;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.models.Event;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Hugo Nebreda
 */
public class SearchEventListInteractor extends AbstractInteractor {
    @Override
    public void runOnBackground() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://private-8b0f5-catalogodeactividadesasde.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiaryService apiary = retrofit.create(ApiaryService.class);


        Log.w(SearchEventListInteractor.class.getSimpleName(), apiary.events().toString());
        Call<List<Event>> call = apiary.events();

        List<Event> events = call.execute().body();

        EventBusUtil.post(events);

    }
}
