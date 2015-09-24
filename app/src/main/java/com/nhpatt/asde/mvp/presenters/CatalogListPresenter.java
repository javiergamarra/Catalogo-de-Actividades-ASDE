package com.nhpatt.asde.mvp.presenters;

import com.nhpatt.asde.async.interactors.SearchCatalogListInteractor;
import com.nhpatt.asde.models.Commit;
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
        new SearchCatalogListInteractor().execute();
    }

    //    @Subscribe
    public void catalogListRetrieved(List<Commit> object) {
        catalogListView.show(object);
    }
}
