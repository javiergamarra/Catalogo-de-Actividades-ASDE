package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchCatalogListInteractor;
import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.mvp.views.CatalogListView;

import java.util.List;

import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * @author Hugo Nebreda
 */

public class CatalogListPresenter extends PresenterImpl {
    private final CatalogListView catalogListView;

    public CatalogListPresenter(CatalogListView catalogListView) {
        this.catalogListView = catalogListView;
    }

    public void searchCatalogList() {
        new SearchCatalogListInteractor().execute();
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void catalogListRetrieved(List<Commits> object) {
        catalogListView.show(object);
    }
}
