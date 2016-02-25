package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.RetrofitAPI;
import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Contributor;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class MainInteractor extends AbstractInteractor {

    private final String owner;
    private final String repo;

    public MainInteractor(String owner, String repo) {
        this.owner = owner;
        this.repo = repo;
    }

    @Override
    public void runOnBackground() throws IOException {

        GitHubService github = RetrofitAPI.getRetrofit().create(GitHubService.class);

        Call<List<Contributor>> call = github.contributors(owner, repo);

        List<Contributor> contributors = call.execute().body();

        EventBusUtil.post(contributors);
    }
}
