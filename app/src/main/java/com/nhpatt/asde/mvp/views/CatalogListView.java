package com.nhpatt.asde.mvp.views;

import com.nhpatt.asde.models.Event;

import java.util.List;

/**
 * @author Hugo Nebreda
 */
public interface CatalogListView {
    //void show(List<Commits> catalogList);

    void show(List<Event> eventList);
    //void click(Commit clickedCommit);
}
