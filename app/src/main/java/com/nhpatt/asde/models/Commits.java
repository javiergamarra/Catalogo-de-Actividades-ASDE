package com.nhpatt.asde.models;

public class Commits {

    private String comments_url;
    private Commit commit;

    public Commits(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

}
