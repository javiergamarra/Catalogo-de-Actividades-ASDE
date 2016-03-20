package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */
public class EventListInteractor extends AbstractInteractor {

    public Observable<List<Event>> run() {
        ApiaryService apiary = getApiary().create(ApiaryService.class);
        return apiary.events();
    }
}
