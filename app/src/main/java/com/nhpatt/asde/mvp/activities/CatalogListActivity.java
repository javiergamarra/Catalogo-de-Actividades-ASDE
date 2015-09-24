package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Commits;
import com.nhpatt.asde.mvp.presenters.CatalogListPresenter;
import com.nhpatt.asde.mvp.views.CatalogListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Nebreda
 */
public class CatalogListActivity extends AbstractActivity<CatalogListPresenter> implements CatalogListView {

    private Button getCatalogListButton;
    private ListView catalogListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_list);

        bindViews();
    }

    private void bindViews() {
        getCatalogListButton = (Button) findViewById(R.id.button_get_catalog_list);
        catalogListView = (ListView) findViewById(R.id.catalog_listview);
    }

    @Override
    protected CatalogListPresenter createPresenter() {
        return new CatalogListPresenter(this);
    }

    public void searchCatalog(View view) {
        getPresenter().searchCatalogList();
    }

    @Override
    public void show(List<Commits> catalogList) {
        List<String> auxList = new ArrayList<>();

        for (int position = 0; position < catalogList.size(); position++) {
            auxList.add(catalogList.get(position).getComments_url());
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, auxList);
        catalogListView.setAdapter(adapter);
    }
}
