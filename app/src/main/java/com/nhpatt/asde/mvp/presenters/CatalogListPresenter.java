package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.EventBusUtil;
import com.nhpatt.asde.async.interactors.SearchCatalogListInteractor;
import com.nhpatt.asde.models.Commits;
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
        new SearchCatalogListInteractor().runOnRx().subscribe(this::catalogListRetrieved);
    }

    public void catalogListRetrieved(List<Commits> object) {
        catalogListView.show(object);
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }
}
