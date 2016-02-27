package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.EventListInteractor;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.views.CatalogListView;

import java.util.List;

/**
 * @author Hugo Nebreda
 */

public class EventListPresenter extends PresenterImpl {
    private final CatalogListView catalogListView;

    public EventListPresenter(CatalogListView catalogListView) {
        this.catalogListView = catalogListView;
    }

    public void searchCatalogList() {
        new EventListInteractor().runOnRx().subscribe(this::eventListRetrieved);
    }

    public void eventListRetrieved(List<Event> object) {
        catalogListView.show(object);
    }

}
