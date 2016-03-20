package com.nhpatt.asde.mvp.activities;

import android.content.res.ObbInfo;
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

    private TextView activityDescriptionTitleTextView;
    private TextView activityDescriptionContentTextView;
    private TextView activityCharacteristicsTitleTextView;
    private TextView activityCharacteristicsContentView;
    private TextView activityMeasuresTitleTextView;
    private TextView activityMeasuresTitleContentView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindViews();

        if (getIntent().getSerializableExtra("event") != null) {
            Event event = (Event) getIntent().getExtras().get("event");
            show(event);
            //getPresenter().searchEvent(event.getId());
        }
    }

    private void bindViews() {
        activityDescriptionTitleTextView = (TextView) findViewById(R.id.activity_description_title_textview);
        activityDescriptionContentTextView = (TextView) findViewById(R.id.activity_description_content_textview);
        activityCharacteristicsTitleTextView = (TextView) findViewById(R.id.activity_characteristics_title_textview);
        activityCharacteristicsContentView = (TextView) findViewById(R.id.activity_characteristics_content_textview);
        activityMeasuresTitleTextView = (TextView) findViewById(R.id.activity_measure_title_textview);
        activityMeasuresTitleContentView = (TextView) findViewById(R.id.activity_measure_content_textview);
    }

    @Override
    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }


    @Override
    public void show(Event object) {
        toolbar.setTitle(object.getName());
        activityDescriptionContentTextView.setText(object.getDescription());
        activityCharacteristicsContentView.setText(object.getCharacteristics().toString());
        activityMeasuresTitleContentView.setText(object.getMeasure().toString());

    }
}
