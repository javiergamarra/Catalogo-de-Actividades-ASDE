package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Commits;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Hugo Nebreda
 */
public class SearchCatalogListInteractor extends AbstractRxInteractor {

    public Observable<List<Commits>> runOnRx() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHubService github = retrofit.create(GitHubService.class);

        return github.commits("nhpatt", "Catalogo-de-Actividades-ASDE")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
