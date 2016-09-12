package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventInteractor;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */

public class EventListPresenter extends FragmentPresenterImpl {

    public static final String KEY = "EVENTS";
    private final EventListView eventListView;

    public EventListPresenter(EventListView eventListView) {
        this.eventListView = eventListView;
    }

    public void searchEventList() {
        Observable<List<Event>> cachedEventObs = getCachedObservable(KEY, new EventInteractor().search());
        cachedEventObs.subscribe(this::eventListRetrieved, this::errorRetrievingInfo);
    }

    public void errorRetrievingInfo(Throwable throwable) {
        invalidateObservable("EVENTS");
        eventListView.onError("Error retrieving list of items");
    }

    public void eventListRetrieved(List<Event> object) {
        eventListView.onSuccess(object);
    }

    public interface EventListView extends BaseView {

        void onSuccess(List<Event> events);
    }

}
