package com.nhpatt.asde.mvp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Commit;
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
    public void show(final List<Commits> catalogList) {
        List<String> auxList = new ArrayList<>();

        for (int position = 0; position < catalogList.size(); position++) {
            auxList.add(catalogList.get(position).getComments_url());
        }

        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, auxList);
        catalogListView.setAdapter(adapter);
        catalogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(parent.getContext(), "Click", Toast.LENGTH_SHORT).show();
                Intent clickedItemIntent = new Intent(parent.getContext(), RiskDetailActivity.class);
                clickedItemIntent.putExtra("commit", catalogList.get(position).getCommit());
                //TODO Recuperar el valor del item clickeado
                //TODO Crear bundle y añadir el valor, y pasar el bundle a la actividad
                startActivity(clickedItemIntent);
            }
        });
    }

    @Override
    public void click(Commit item){

    }



}