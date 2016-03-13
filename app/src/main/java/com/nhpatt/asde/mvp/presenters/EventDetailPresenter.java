package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventInteractor;
import com.nhpatt.asde.models.Event;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends PresenterImpl {

    private static Observable<Event> run;
    private static String eventId;
    private final EventDetailView eventDetailView;

    public EventDetailPresenter(EventDetailView eventDetailView) {
        this.eventDetailView = eventDetailView;
    }

    public void searchEvent(String eventId) {
        //TODO fix this
        if (run == null || !eventId.equals(this.eventId)) {
            this.eventId = eventId;
            run = new EventInteractor().runInBackground(eventId);
        }
        run.compose(bindToLifecycle()).subscribe(this::eventRetrieved);
    }

    public void eventRetrieved(Event object) {
        eventDetailView.show(object);
    }

    public interface EventDetailView {
        void show(Event object);
    }

}
