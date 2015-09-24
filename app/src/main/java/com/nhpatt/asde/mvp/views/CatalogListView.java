package com.nhpatt.asde.mvp.views;

import com.nhpatt.asde.models.Commits;

import java.util.List;

/**
 * @author Hugo Nebreda
 */
public interface CatalogListView {
    void show(List<Commits> catalogList);
}
