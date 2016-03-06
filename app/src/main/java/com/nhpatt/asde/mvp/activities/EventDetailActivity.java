package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.presenters.EventDetailPresenter;

/**
 * @author Javier Gamarra
 */
public class EventDetailActivity extends AbstractActivity<EventDetailPresenter>
        implements EventDetailPresenter.EventDetailView {

    private TextView activityNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindViews();

        if (getIntent().getSerializableExtra("event") != null) {
            Event event = (Event) getIntent().getExtras().get("event");
            getPresenter().searchEvent(event.getId());
        }
    }

    private void bindViews() {
        activityNameTextView = (TextView) findViewById(R.id.activity_name_textview);
    }

    @Override
    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }


    @Override
    public void show(Event object) {
        activityNameTextView.setText(object.getCreated());
    }
}
