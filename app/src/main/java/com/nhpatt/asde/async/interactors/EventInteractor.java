package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventInteractor extends AbstractInteractor {

    @Override
    public Observable<Event> run() {
        ApiaryService apiaryService = getApiary().create(ApiaryService.class);
        return apiaryService.eventWithId("1").compose(applySchedulers());
    }

}
