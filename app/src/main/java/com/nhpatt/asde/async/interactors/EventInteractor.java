package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventInteractor extends AbstractInteractor {

    @Override
    public Observable run(Object... arguments) {
        ApiaryService apiaryService = getApiary().create(ApiaryService.class);
        return apiaryService.eventWithId((String) arguments[0]);
    }
}
