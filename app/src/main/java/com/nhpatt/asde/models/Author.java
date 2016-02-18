package com.nhpatt.asde.models;

import java.io.Serializable;

/**
 * @author Javier Gamarra
 */
public class Author implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
