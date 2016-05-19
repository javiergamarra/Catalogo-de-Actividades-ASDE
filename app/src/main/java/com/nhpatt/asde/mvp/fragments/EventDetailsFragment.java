package com.nhpatt.asde.mvp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;

/**
 * @author Hugo Nebreda
 */
public class EventDetailsFragment extends Fragment {

    private TextView descriptionContentTextView;
    private TextView characteristicsContentView;
    private TextView measuresTitleContentView;

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
        descriptionContentTextView = (TextView) view.findViewById(R.id.description_content_textview);
        characteristicsContentView = (TextView) view.findViewById(R.id.characteristics_content_textview);
        measuresTitleContentView = (TextView) view.findViewById(R.id.measure_content_textview);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            Event event = (Event) args.getSerializable("event");
            showEvent(event);
        }
    }

    public void showEvent(Event event) {
        descriptionContentTextView.setText(event.getDescription());
        characteristicsContentView.setText(event.getCharacteristicsAsString());
        measuresTitleContentView.setText(event.getMeasure().toString());
    }

}

