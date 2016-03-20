package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventListInteractor;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */

public class EventListPresenter extends PresenterImpl {

    private final EventListView eventListView;

    public EventListPresenter(EventListView eventListView) {
        this.eventListView = eventListView;
    }

    public void searchEventList() {
        Observable<List<Event>> eventListObs = new EventListInteractor().run();
        Observable<List<Event>> cachedEventListObs = getCachedBackgroundObservable("EVENTS", eventListObs);
        cachedEventListObs.subscribe(this::eventListRetrieved, this::errorRetrievingInfo);
    }

    public void errorRetrievingInfo(Throwable throwable) {
        eventListView.showError("Error retrieving list of items");
    }

    public void eventListRetrieved(List<Event> object) {
        eventListView.show(object);
    }

    public interface EventListView {
        void show(List<Event> eventList);

        void showError(String message);
    }

}
