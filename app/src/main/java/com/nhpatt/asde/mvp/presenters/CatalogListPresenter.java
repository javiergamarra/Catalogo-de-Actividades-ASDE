package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchCatalogListInteractor;
import com.nhpatt.asde.async.interactors.SearchEventListInteractor;
import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.views.CatalogListView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * @author Hugo Nebreda
 */

public class CatalogListPresenter extends PresenterImpl {
    private final CatalogListView catalogListView;

    public CatalogListPresenter(CatalogListView catalogListView) {
        this.catalogListView = catalogListView;
    }

    public void searchCatalogList() {
        //new SearchCatalogListInteractor().execute();
        new SearchEventListInteractor().execute();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventListRetrieved(List<Event> object) {
        catalogListView.show(object);
    }
}
