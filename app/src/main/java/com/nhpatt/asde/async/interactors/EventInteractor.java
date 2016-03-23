package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventInteractor extends AbstractInteractor {

    public Observable run(String eventId) {
        ApiaryService apiaryService = getApiary().create(ApiaryService.class);
        return apiaryService.getEventWithId(eventId);
    }
}
