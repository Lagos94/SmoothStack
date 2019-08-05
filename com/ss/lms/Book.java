package com.ss.lms;

import java.util.Objects;

public class Book {
private Integer authorID;
private Integer pubID;
private Integer bookID;

public Book(){}

public Book(Integer authorID, Integer pubID, Integer bookID){
    this.authorID = authorID;
    this.pubID = pubID;
    this.bookID = bookID;
}

    public Integer getAuthorID() { return authorID; }
    public void setAuthorID(Integer authorID) { this.authorID = authorID; }

    public Integer getPubID() { return pubID; }
    public void setPubID(Integer pubID) { this.pubID = pubID; }

    public Integer getBookID() { return bookID; }
    public void setBookID(Integer bookID) { this.bookID = bookID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(authorID, book.authorID) &&
                Objects.equals(pubID, book.pubID) &&
                Objects.equals(bookID, book.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorID, pubID, bookID);
    }
}
