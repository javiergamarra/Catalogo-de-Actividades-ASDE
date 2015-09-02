package com.nhpatt.asde.presenters;

import com.nhpatt.asde.activities.MainView;
import com.nhpatt.asde.interactors.MainInteractor;

import de.greenrobot.event.Subscribe;

public class MainPresenter extends PresenterImpl {

    private final MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void lookForThings(String owner, String repo) {
        new MainInteractor(owner, repo).execute();
    }

    @Subscribe
    public void handle(Object object) {
        mainView.showResponse(object.toString());
    }
}
