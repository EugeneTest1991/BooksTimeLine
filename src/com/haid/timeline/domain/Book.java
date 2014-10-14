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

    // TODO maybe delete
    public Book() {

    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actionEnd == null) ? 0 : actionEnd.hashCode());
        result = prime * result + ((actionStart == null) ? 0 : actionStart.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        if (actionEnd == null) {
            if (other.actionEnd != null) {
                return false;
            }
        } else if (!actionEnd.equals(other.actionEnd)) {
            return false;
        }
        if (actionStart == null) {
            if (other.actionStart != null) {
                return false;
            }
        } else if (!actionStart.equals(other.actionStart)) {
            return false;
        }
        if (author == null) {
            if (other.author != null) {
                return false;
            }
        } else if (!author.equals(other.author)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append("]");
        return builder.toString();
    }

}
