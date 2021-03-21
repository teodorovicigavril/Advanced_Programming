package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidCatalogException, ClassNotFoundException {

        Song s1 = new Song("1","s1", "/test");
        Song s2 = new Song("2","s2", "/test");
        Image b1 = new Image("3","b1", "/test");
        Image b2 = new Image("4","b22", ".\\test.png");

            // TESTING EXCEPTIONS
        //s1.setName("   ");
        //s1.setReleaseDate(2023,12,24);
        //System.out.println(s1.toString());

        System.out.println("------");
        Catalog catalog = new Catalog();
        catalog.add(s1);
        catalog.add(s2);
        catalog.add(b1);
        catalog.add(b2);

        //catalog.play(b2);
        catalog.setPath(".\\output.txt");
        catalog.setName("Catalog 1");

        catalog.list();
       // CatalogUtil catalogUtil = new CatalogUtil();
        CatalogUtil.save(catalog);

        Catalog catalog1 = new Catalog();
        catalog1.setPath(".\\auxFile.txt");
        Image imageAux = new Image("5","testImg", ".\\test.png");
        catalog1.add(imageAux);
        //catalog1 = CatalogUtil.load(catalog.getPath());
        CatalogUtil.save(catalog1);

        catalog1.list();

        System.out.println("From shell -------------");
        Shell shell = new Shell(catalog);
        shell.getCatalog().list();
        shell.run();
        shell.getCatalog().list();
    }
}
