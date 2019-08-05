package com.ss.lms;

import java.util.Objects;

public class Publisher {
private String pubName;
private String pubAddress;
private Integer pubID;

public Publisher(){}

public Publisher(String pubName, String pubAddress, Integer pubID){
    this.pubAddress=pubAddress;
    this.pubName=pubName;
    this.pubID=pubID;
}

    public String getPubName() { return pubName; }
    public void setPubName(String pubName) { this.pubName = pubName; }

    public String getPubAddress() { return pubAddress; }
    public void setPubAddress(String pubAddress) { this.pubAddress = pubAddress; }

    public Integer getPubID() { return pubID; }
    public void setPubID(Integer pubID) { this.pubID = pubID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(pubName, publisher.pubName) &&
                Objects.equals(pubAddress, publisher.pubAddress) &&
                Objects.equals(pubID, publisher.pubID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pubName, pubAddress, pubID);
    }
}
