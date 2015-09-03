package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.models.Contributor;
import com.nhpatt.asde.async.services.GitHubService;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainInteractor extends AbstractInteractor {

    private final String owner;
    private final String repo;

    public MainInteractor(String owner, String repo) {
        this.owner = owner;
        this.repo = repo;
    }

    @Override
    public void runOnBackground() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService github = retrofit.create(GitHubService.class);

        Call<List<Contributor>> call = github.contributors(owner, repo);

        List<Contributor> contributors = call.execute().body();

        EventBusUtil.post(contributors);
    }
}
