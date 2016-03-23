package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventInteractor;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends PresenterImpl {

    private final EventDetailView eventDetailView;

    public EventDetailPresenter(EventDetailView eventDetailView) {
        this.eventDetailView = eventDetailView;
    }

    public void searchEvent(String eventId) {
        Observable<Event> eventInteractor = new EventInteractor().run(eventId);
        Observable<Event> cachedEventObs = getCachedBackgroundObservable(eventId, eventInteractor);
        cachedEventObs.subscribe(this::eventRetrieved);
    }

    public void eventRetrieved(Event object) {
        eventDetailView.show(object);
    }

    public interface EventDetailView {
        void show(Event object);
    }

}
