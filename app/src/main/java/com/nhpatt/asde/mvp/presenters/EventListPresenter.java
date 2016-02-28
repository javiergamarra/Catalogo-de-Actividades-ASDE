package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventListInteractor;
import com.nhpatt.asde.models.Event;

import java.util.List;

import rx.Observable;

/**
 * @author Hugo Nebreda
 */

public class EventListPresenter extends PresenterImpl {

    private static Observable<List<Event>> observable = new EventListInteractor().run().cache();

    private final EventListView eventListView;

    public EventListPresenter(EventListView eventListView) {
        this.eventListView = eventListView;
    }

    public void searchEventList() {
        observable.subscribe(this::eventListRetrieved);
    }

    public void eventListRetrieved(List<Event> object) {
        eventListView.show(object);
    }

    public interface EventListView {
        void show(List<Event> eventList);
    }

}
