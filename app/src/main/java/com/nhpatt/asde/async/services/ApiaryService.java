package com.nhpatt.asde.async.services;

import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.models.Contributor;
import com.nhpatt.asde.models.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiaryService {
    @GET("/activities")
    Call<List<Event>> events();

}