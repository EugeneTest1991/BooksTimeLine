package com.haid.timeline.domain;

import java.io.Serializable;
import java.util.Date;

public final class Book implements Serializable {

    private static final long serialVersionUID = 0L;
    private Long id;
    private String author;
    private String title;
    private Date actionStart;
    private Date actionEnd;

    public Book(Long id, String author, String title, Date actionStart, Date actionEnd) {
        super();
        this.id = id;
        this.author = author;
        this.title = title;
        this.actionStart = actionStart;
        this.actionEnd = actionEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getActionStart() {
        return actionStart;
    }

    public void setActionStart(Date actionStart) {
        this.actionStart = actionStart;
    }

    public Date getActionEnd() {
        return actionEnd;
    }

    public void setActionEnd(Date actionEnd) {
        this.actionEnd = actionEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
