package com.nhpatt.asde.presenters;

import com.nhpatt.asde.activities.RiskDetailView;

import de.greenrobot.event.Subscribe;

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
