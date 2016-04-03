package com.nhpatt.asde.mvp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.activities.AbstractActivity;
import com.nhpatt.asde.mvp.activities.EventDetailActivity;
import com.nhpatt.asde.mvp.activities.EventListener;
import com.nhpatt.asde.mvp.activities.EventsAdapter;
import com.nhpatt.asde.mvp.presenters.EventListPresenter;

import java.util.List;

/**
 * @author Hugo Nebreda
 */
public class EventListFragment extends AbstractActivity<EventListPresenter>
        implements EventListPresenter.EventListView, EventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getPresenter().searchEventList();
    }

    @Override
    protected EventListPresenter createPresenter() {
        return new EventListPresenter(this);
    }

    @Override
    public void show(final List<Event> events) {
        RecyclerView eventRecyclerView = (RecyclerView) findViewById(R.id.event_recycler);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventRecyclerView.setAdapter(new EventsAdapter(events, this));
    }

    @Override
    public void click(Event event) {
        Intent intent = new Intent(this, EventDetailActivity.class);
        intent.putExtra("event", event);
        startActivity(intent);
    }
}

