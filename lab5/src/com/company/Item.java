package com.company;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Item implements Serializable {

    private String id;
    private String name;
    private String path;

    private LocalDate releaseDate;

    public Item(String id, String name, String path) throws InvalidCatalogException {
        if(id == null || id.contains("[a-zA-Z]+") || id.trim().equals("")){
            throw new InvalidCatalogException("Invalid id! Don't use letters and don't let it blank!");
        }
        this.id = id;
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("Empty name!");
        }
        this.name = name;
        if(path.isEmpty()) throw new InvalidCatalogException("Empty path!");
        this.path = path;
    }

    public Item(String id, String name, String path, int year, int month, int day) throws InvalidCatalogException {
        if(year >= 2022 || year <= 1500 || month > 12 ||
                month <= 0 || day <= 0 || day > 31) {
            throw new InvalidCatalogException(year,month,day);
        }
        this.releaseDate = LocalDate.parse(year+"-"+month+"-"+day);
        if(id == null || id.contains("[a-zA-Z]+") || id.trim().equals("")){
            throw new InvalidCatalogException("Invalid id! Don't use letters and don't let it blank!");
        }
        this.id = id;
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("Empty name!");
        }
        this.name = name;
        if(path.isEmpty()) throw new InvalidCatalogException("Empty path!");
        this.path = path;
    }

    public Item() {

    }

    public void setId(String id) throws InvalidCatalogException {
        if(id == null || id.contains("[a-zA-Z]+") || id.trim().equals("")){
            throw new InvalidCatalogException("Invalid id! Don't use letters and don't let it blank!");
        }
        this.id = id;
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int year, int month, int day) throws InvalidCatalogException {
        if(year >= 2022 || year <= 1500 || month > 12 ||
                month <= 0 || day <= 0 || day > 31) {
            throw new InvalidCatalogException(year,month,day);
        }
        this.releaseDate = LocalDate.parse(year+"-"+month+"-"+day);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
