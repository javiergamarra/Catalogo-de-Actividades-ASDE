package com.nhpatt.asde.mvp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;
import com.nhpatt.asde.mvp.presenters.EventDetailPresenter;

/**
 * @author Hugo Nebreda
 */
public class EventDetailsFragment extends AbstractFragment<EventDetailPresenter>
        implements EventDetailPresenter.EventDetailView {

    private TextView descriptionContentTextView;
    private TextView characteristicsContentView;
    private TextView measuresTitleContentView;
    private Toolbar eventToolbar;
    private Event currentEvent;


    public static EventDetailsFragment newInstance(Event event) {
        EventDetailsFragment f = new EventDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable("event", event);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_detail, container, false);
        return view;
    }

    protected EventDetailPresenter createPresenter() {
        return new EventDetailPresenter(this);
    }


    @Override
    public void onResume() {
        super.onResume();


        Bundle args = getArguments();
        if (args != null) {
            currentEvent = (Event) args.getSerializable("event");
            show(currentEvent);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindViews();
    }

    @Override
    public void show(Event object) {
        eventToolbar.setTitle(object.getName());
        descriptionContentTextView.setText(object.getDescription());
        characteristicsContentView.setText(object.getCharacteristicsAsString());
        measuresTitleContentView.setText(object.getMeasure().toString());
    }

    private void bindViews() {
        eventToolbar = (Toolbar) getActivity().findViewById(R.id.event_toolbar);
        descriptionContentTextView = (TextView) getActivity().findViewById(R.id.description_content_textview);
        characteristicsContentView = (TextView) getActivity().findViewById(R.id.characteristics_content_textview);
        measuresTitleContentView = (TextView) getActivity().findViewById(R.id.measure_content_textview);
    }

}

