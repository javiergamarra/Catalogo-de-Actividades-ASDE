package com.nhpatt.asde.models;

import java.io.Serializable;


public class Event implements Serializable {
    private final String name;
    private final String id;

    public Event(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
