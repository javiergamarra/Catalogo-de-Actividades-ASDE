package com.nhpatt.asde.models;

public class Commit {
    private final String author;
    private final String message;
    private final String date;

    public Commit(String author, String message, String date) {
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
