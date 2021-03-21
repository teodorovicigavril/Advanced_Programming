package com.company;

import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(catalog.getPath());
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
                out.writeObject(catalog);
        }
        finally {
            System.out.println("Saved!");
        }
    }

    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        Catalog catalog;
        try(FileInputStream fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis)) {
            catalog = (Catalog)in.readObject();
        }
        System.out.println("Successfully load!");
        return catalog;
    }

}
