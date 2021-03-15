package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Song s1 = new Song("s1", "/test");
        Song s2 = new Song("s2", "/test");
        Book b1 = new Book("b1", "/test");
        Book b2 = new Book("b22", "/test");

        System.out.println("------");
        Catalog catalog = new Catalog();
        catalog.add(s1);
        catalog.add(s2);
        catalog.add(b1);
        catalog.add(b2);


        catalog.list();
        catalog.save("output.txt");
        catalog.load("C:\\Users\\40756\\Desktop\\gabii\\iasi\\ANUL 2\\sem 2\\ap\\lab5\\src\\com\\company\\output.txt");
        catalog.list();
    }
}
