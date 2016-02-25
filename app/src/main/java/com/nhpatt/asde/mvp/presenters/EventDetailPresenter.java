package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchEventInteractor;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.views.EventDetailView;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends PresenterImpl {

    private final EventDetailView eventDetailView;

    public EventDetailPresenter(EventDetailView eventDetailView) {
        this.eventDetailView = eventDetailView;
    }

    public void search() {
        new SearchEventInteractor().runOnRx().subscribe(this::eventRetrieved);
    }

    public void eventRetrieved(Event object) {
        eventDetailView.show(object);
    }

}
