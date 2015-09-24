package com.nhpatt.asde.async.services;

import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.models.Contributor;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubService {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);


    @GET("/repos/{owner}/{repo}/commits")
    Call<List<Commits>> commits(
            @Path("owner") String owner,
            @Path("repo") String repo);

}