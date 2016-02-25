package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchEventListInteractor;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.views.CatalogListView;

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
        new SearchEventListInteractor().runOnRx().subscribe(this::eventListRetrieved);
    }

    public void eventListRetrieved(List<Event> object) {
        catalogListView.show(object);
    }

}
