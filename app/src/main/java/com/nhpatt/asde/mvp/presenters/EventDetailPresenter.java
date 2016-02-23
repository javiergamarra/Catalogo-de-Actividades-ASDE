package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchEventInteractor;
import com.nhpatt.asde.async.interactors.SearchEventListInteractor;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.views.EventDetailView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends PresenterImpl {

    private final EventDetailView eventDetailView;

    public EventDetailPresenter(EventDetailView eventDetailView) {
        this.eventDetailView = eventDetailView;
    }

    public void search() {
        new SearchEventInteractor().execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventRetrieved(Event object) {
        eventDetailView.show(object);
    }
}
