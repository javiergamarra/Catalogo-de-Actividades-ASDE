package com.nhpatt.asde.mvp.activities;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * @author Javier Gamarra
 */
public class PersistedObject {

    private Map<String, Observable> interactors = new HashMap<>();

    public Map<String, Observable> getInteractors() {
        return interactors;
    }

    public void setInteractors(Map<String, Observable> interactors) {
        this.interactors = interactors;
    }

}
