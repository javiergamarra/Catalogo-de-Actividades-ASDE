package com.nhpatt.asde.async.services;

import com.nhpatt.asde.models.Event;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiaryService {

    @GET("/activities")
    Observable<List<Event>> getEventList();

    @GET("/activities/{id}")
    Observable<Event> getEventWithId(@Path("id") String id);
}