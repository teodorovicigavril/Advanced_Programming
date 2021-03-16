package com.company;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private ArrayList<Item> items;

    public Catalog(ArrayList<Item> items, String name, String path) throws InvalidCatalogException {
        this.items = new ArrayList<>();
        this.items = items;
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("Empty name!");
        }
        this.name = name;
        if(path.isEmpty()) throw new InvalidCatalogException("Empty path!");
        this.path = path;
    }

    public Catalog() {
        this.items = new ArrayList<>();
        this.name = null;
        this.path = null;
    }

    public Catalog(String name, String path) throws InvalidCatalogException {
        this.items = new ArrayList<>();
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("Empty name!");
        }
        this.name = name;
        if(path.isEmpty()) throw new InvalidCatalogException("Empty path!");
        this.path = path;
    }


    public void add(Item item){
        this.items.add(item);
    }

    public void list(){
        System.out.println("Name of catalog " + this.getName());
        System.out.println("Path: " + this.getPath());
        System.out.println("Content of catalog: ");
        for(Item index: this.items){
            System.out.print("\t-" + index.getClass().getSimpleName() + " " + index.getName());
            System.out.println(); // endl
        }
    }

    public void play(Item item){
        File file = null;
        for(Item index: this.items){
            if(index.getName().equals(item.getName()))
                file = new File(index.getPath());
        }

            if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) desktop.open(file);

        } catch( IOException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }



    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", items=" + items +
                '}';
    }

    public void setName(String name) throws InvalidCatalogException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("Empty name!");
        }
        this.name = name;
    }

    public void setPath(String path) throws InvalidCatalogException {
        if(path.isEmpty()) throw new InvalidCatalogException("Empty path!");
        this.path = path;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
