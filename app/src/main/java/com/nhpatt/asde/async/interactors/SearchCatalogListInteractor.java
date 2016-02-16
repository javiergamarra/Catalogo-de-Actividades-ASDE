package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Commits;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Hugo Nebreda
 */
public class SearchCatalogListInteractor extends AbstractInteractor {
    @Override
    public void runOnBackground() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService github = retrofit.create(GitHubService.class);

        Call<List<Commits>> call = github.commits("nhpatt", "Catalogo-de-Actividades-ASDE");

        List<Commits> commits = call.execute().body();

        EventBusUtil.post(commits);

    }
}
