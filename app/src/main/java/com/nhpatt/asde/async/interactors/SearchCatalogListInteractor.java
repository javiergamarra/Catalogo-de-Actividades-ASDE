package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.services.GitHubService;
import com.nhpatt.asde.models.Commit;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

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


        Call<List<Commit>> call = github.commits("nhpatt", "Catalogo-de-Actividades-ASDE");

        List<Commit> commits = call.execute().body();

        EventBusUtil.post(commits);

    }
}
