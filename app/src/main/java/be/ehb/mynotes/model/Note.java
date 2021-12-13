package be.ehb.mynotes.model;


import org.threeten.bp.LocalDate;

import java.io.Serializable;

public class Note implements Serializable {

    private long id;
    private String title, content;
    private LocalDate publishDate, lastModifiedDate;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.publishDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
