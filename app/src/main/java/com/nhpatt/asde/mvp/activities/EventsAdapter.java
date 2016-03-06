package com.nhpatt.asde.mvp.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhpatt.asde.R;
import com.nhpatt.asde.models.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Gamarra
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private final EventListener listener;
    private List<Event> events = new ArrayList<>();

    public EventsAdapter(List<Event> events, EventListener listener) {
        this.events = events;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new EventsViewHolder(inflater.inflate(R.layout.event_row, parent, false));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView eventName;

        public EventsViewHolder(View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.event_name);
            itemView.setOnClickListener(this);
        }

        public void bind(Event event) {
            eventName.setText(event.getName());
        }

        @Override
        public void onClick(View v) {
            listener.click(events.get(getAdapterPosition()));
        }
    }
}
