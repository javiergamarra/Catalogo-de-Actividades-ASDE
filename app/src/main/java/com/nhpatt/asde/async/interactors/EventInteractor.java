package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventInteractor extends AbstractInteractor {

    public Observable<Event> run(String id) {
        ApiaryService apiaryService = getApiary().create(ApiaryService.class);
        return apiaryService.eventWithId(id).compose(applySchedulers());
    }

}
