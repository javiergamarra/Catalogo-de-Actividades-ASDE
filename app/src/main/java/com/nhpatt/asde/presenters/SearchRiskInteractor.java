package com.nhpatt.asde.presenters;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.interactors.AbstractInteractor;
import com.nhpatt.asde.models.Contributor;
import com.nhpatt.asde.services.GitHubService;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * @author Javier Gamarra
 */
public class SearchRiskInteractor extends AbstractInteractor {
    @Override
    public void runOnBackground() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService github = retrofit.create(GitHubService.class);

        Call<List<Contributor>> call = github.contributors("nhpatt", "javascript-learning-group");

        List<Contributor> contributors = call.execute().body();

        EventBusUtil.post(String.valueOf(contributors.get(0)));
    }
}
