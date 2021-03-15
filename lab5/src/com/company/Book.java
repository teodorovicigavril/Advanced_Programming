package com.company;

public class Book extends Entry{
    public Book(String name, String path) {
        super(name, path);
        this.setType(2);
    }
}
