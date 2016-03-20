package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */
public class EventListInteractor extends AbstractInteractor {

    @Override
    public Observable run(Object... arguments) {
        ApiaryService apiary = getApiary().create(ApiaryService.class);
        return apiary.getEventList();
    }
}
