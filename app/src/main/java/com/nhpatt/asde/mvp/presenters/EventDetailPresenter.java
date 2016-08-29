package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventInteractor;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends FragmentPresenterImpl {

    private final EventDetailView eventDetailView;

    public EventDetailPresenter(EventDetailView eventDetailView) {
        this.eventDetailView = eventDetailView;
    }

    public void searchEvent(String eventId) {
        Observable<Event> cachedEventObs = getCachedObservable(
                eventId, new EventInteractor().searchById(eventId));
        cachedEventObs.subscribe(this::eventRetrieved, (t) -> {
            invalidateObservable(eventId);
            eventDetailView.showError("Error retrieving item");
        });
    }

    public void eventRetrieved(Event object) {
        eventDetailView.show(object);
    }

    public interface EventDetailView {
        void show(Event object);

        void showError(String message);
    }

}
