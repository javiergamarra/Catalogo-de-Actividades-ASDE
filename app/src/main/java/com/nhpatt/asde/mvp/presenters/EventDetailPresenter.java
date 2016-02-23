package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchEventInteractor;
import com.nhpatt.asde.mvp.views.RiskDetailView;

import org.greenrobot.eventbus.Subscribe;

/**
 * @author Javier Gamarra
 */
public class EventDetailPresenter extends PresenterImpl {

    private final RiskDetailView riskDetailView;

    public EventDetailPresenter(RiskDetailView riskDetailView) {
        this.riskDetailView = riskDetailView;
    }

    public void search() {
        new SearchEventInteractor().execute();
    }

    @Subscribe
    public void riskRetrieved(String object) {
        riskDetailView.show(object);
    }
}
