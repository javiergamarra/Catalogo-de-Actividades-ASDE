package com.nhpatt.asde.mvp.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Commit;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.presenters.EventDetailPresenter;
import com.nhpatt.asde.mvp.views.EventDetailView;

/**
 * @author Javier Gamarra
 */
public class EventDetailActivity extends AbstractActivity<EventDetailPresenter>
        implements EventDetailView {

    private TextView activityNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        bindViews();

        if (null != getIntent()) {
            Event event = (Event) getIntent().getExtras().get("event");
            assert event != null;
            //activityNameTextView.setText(event.getName());
            getPresenter().search();
        }

    }

    private void bindViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityNameTextView = (TextView) findViewById(R.id.activity_name_textview);
    }

    @Override
    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }


    @Override
    public void show(Event object) {
        activityNameTextView.setText(object.getName());
    }
}
