package com.salesforce.dev.framework.dto;

/**
 * Created by Veronica Prado on 9/5/2015.
 */
public class Chatter {
    private String post;
    private String comment;
    public Chatter(){}

    public String getComment() {
        return comment;
    }

    public String getPost() {
        return post;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
