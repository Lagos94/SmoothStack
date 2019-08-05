package com.ss.lms;

import javafx.beans.property.SimpleStringProperty;

public class LMS {

    public final SimpleStringProperty bookName;
    public final SimpleStringProperty author;
    public final SimpleStringProperty publisher;

    public LMS(String book, String author, String publisher) {
        this.bookName = new SimpleStringProperty(book);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
    }

    public String getBookName() {
        return bookName.get();
    }

    public void setBookName(String fName) {
        bookName.set(fName);
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String fName) {
        author.set(fName);
    }

    public String getPublisher() {
        return publisher.get();
    }

    public void setPublisher(String fName) {
        publisher.set(fName);
    }
}
