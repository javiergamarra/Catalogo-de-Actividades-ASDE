package com.nhpatt.asde.mvp.views;

import com.nhpatt.asde.models.Commit;

import java.util.List;

/**
 * @author Hugo Nebreda
 */
public interface CatalogListView {
    void show(List<Commit> catalogList);
}
