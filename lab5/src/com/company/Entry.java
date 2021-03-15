package com.company;

import java.io.File;
import java.util.Date;

public class Entry {
    private String name;
    private String path;
    private Date releaseDate;
    private int type;

    public Entry(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
