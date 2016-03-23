package com.nhpatt.asde.async.interactors;

import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventInteractor extends AbstractInteractor {

    private ApiaryService apiaryService = getApiary().create(ApiaryService.class);

    public Observable<List<Event>> search() {
        return apiaryService.getEventList();
    }

    public Observable searchById(String eventId) {
        return apiaryService.getEventWithId(eventId);
    }
}
