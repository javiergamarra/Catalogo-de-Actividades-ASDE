package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventListInteractor;
import com.nhpatt.asde.models.Event;

import java.util.List;

/**
 * @author Hugo Nebreda
 */

public class EventListPresenter extends PresenterImpl {

    private final EventListView eventListView;

    public EventListPresenter(EventListView eventListView) {
        this.eventListView = eventListView;
    }

    public void searchEventList() {
        new EventListInteractor().run().subscribe(this::eventListRetrieved);
    }

    public void eventListRetrieved(List<Event> object) {
        eventListView.show(object);
    }

    public interface EventListView {
        void show(List<Event> eventList);
    }

}
