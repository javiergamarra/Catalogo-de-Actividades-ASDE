package com.nhpatt.asde.mvp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.presenters.CatalogListPresenter;
import com.nhpatt.asde.mvp.views.CatalogListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hugo Nebreda
 */
public class EventListActivity extends AbstractActivity<CatalogListPresenter> implements CatalogListView {

    private ListView catalogListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_list);

        bindViews();
    }

    private void bindViews() {
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
    public void show(final List<Event> eventList) {
        List<String> auxList = new ArrayList<>();

        for (int position = 0; position < eventList.size(); position++) {
            auxList.add(eventList.get(position).getName());
        }

        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, auxList);
        catalogListView.setAdapter(adapter);
        catalogListView.setOnItemClickListener((parent, view, position, id) -> {

            Toast.makeText(parent.getContext(), "Click", Toast.LENGTH_SHORT).show();
            Intent clickedItemIntent = new Intent(parent.getContext(), EventDetailActivity.class);
            clickedItemIntent.putExtra("event", eventList.get(position));
            startActivity(clickedItemIntent);
        });
    }

}
