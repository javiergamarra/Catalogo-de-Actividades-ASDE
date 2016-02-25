package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.RetrofitAPI;
import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Commits;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Hugo Nebreda
 */
public class SearchCatalogListInteractor extends AbstractRxInteractor {

    public Observable<List<Commits>> runOnRx() {

        GitHubService github = RetrofitAPI.getRetrofit().create(GitHubService.class);

        return github.commits("nhpatt", "Catalogo-de-Actividades-ASDE")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
