package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchRiskInteractor;
import com.nhpatt.asde.mvp.views.RiskDetailView;

import org.greenrobot.eventbus.Subscribe;

/**
 * @author Javier Gamarra
 */
public class RiskDetailPresenter extends PresenterImpl {

    private final RiskDetailView riskDetailView;

    public RiskDetailPresenter(RiskDetailView riskDetailView) {
        this.riskDetailView = riskDetailView;
    }

    public void search() {
        new SearchRiskInteractor().execute();
    }

    @Subscribe
    public void riskRetrieved(String object) {
        riskDetailView.show(object);
    }
}
