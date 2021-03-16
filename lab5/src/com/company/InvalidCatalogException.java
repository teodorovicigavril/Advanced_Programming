package com.company;

public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(String ex) {
        super(ex);
    }

    public InvalidCatalogException(int year, int monthValue, int dayOfMonth) {
        super("Wrong release date: " + dayOfMonth + " / " + monthValue + " / " + year);
    }
}
