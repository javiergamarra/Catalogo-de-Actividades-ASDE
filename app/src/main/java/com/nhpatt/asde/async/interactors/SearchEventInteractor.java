package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.RetrofitAPI;
import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class SearchEventInteractor extends AbstractInteractor {

    public Observable<Event> runOnRx() {

        ApiaryService apiaryService = RetrofitAPI.getApiary().create(ApiaryService.class);
        return apiaryService.eventWithId("1").compose(applySchedulers());
    }

}
