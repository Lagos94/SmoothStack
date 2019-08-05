package com.ss.lms;

import java.util.Objects;

public class Author {
private String authorName;
private Integer authorID;

public Author(){}

public Author(String authorName, Integer authorID){
    this.authorName=authorName;
    this.authorID=authorID;
}
    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public Integer getAuthorID() { return authorID; }
    public void setAuthorID(Integer authorID) { this.authorID = authorID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorName, author.authorName) &&
                Objects.equals(authorID, author.authorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName, authorID);
    }
}
