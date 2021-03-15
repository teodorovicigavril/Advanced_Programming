package com.company;

public class Song extends Entry{
    public Song(String name, String path) {
        super(name, path);
        this.setType(1);
    }
}
