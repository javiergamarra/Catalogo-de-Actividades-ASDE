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

    private TextView descriptionContentTextView;
    private TextView characteristicsContentView;
    private TextView measuresTitleContentView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bindViews();

        if (getIntent().getSerializableExtra("event") != null) {
            Event event = (Event) getIntent().getSerializableExtra("event");
            show(event);
//            getPresenter().searchEvent(event.getId());
        }
    }

    private void bindViews() {
        descriptionContentTextView = (TextView) findViewById(R.id.description_content_textview);
        characteristicsContentView = (TextView) findViewById(R.id.characteristics_content_textview);
        measuresTitleContentView = (TextView) findViewById(R.id.measure_content_textview);
    }

    @Override
    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }

    @Override
    public void show(Event object) {
        toolbar.setTitle(object.getName());
        descriptionContentTextView.setText(object.getDescription());
        characteristicsContentView.setText(object.getCharacteristicsAsString());
        measuresTitleContentView.setText(object.getMeasure().toString());
    }
}
