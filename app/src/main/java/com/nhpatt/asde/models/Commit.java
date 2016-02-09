package com.nhpatt.asde.models;

import java.io.Serializable;

/**
 * @author Javier Gamarra
 */
public class Commit implements Serializable{
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
