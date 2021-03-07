package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Location implements Comparable<Location> {
    private String description;
    private double aria;
    private String name;
    private HashMap<Location, Integer> cost;

    public Location() {
        this.description = "";
        this.aria = 0.00;
        this.name = "";
        this.cost = new HashMap<Location, Integer>();
    }

    public Location(String description, double aria, String name, HashMap<Location, Integer> cost) {
        this.cost = new HashMap<Location, Integer>();
        this.description = description;
        this.aria = aria;
        this.name = name;
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(HashMap<Location, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    public String getDescription() {
        return description;
    }

    public double getAria() {
        return aria;
    }

    public String getName() {
        return name;
    }

    public HashMap<Location, Integer> getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Location{" +
                "description='" + description + '\'' +
                ", aria=" + aria +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

   /* @Override
    public int compareTo(Location other) {
        if (this.name == null || other.name == null) {
            System.out.println("Nume null!");
            return -2;
        }
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }*/

    @Override
    public int compareTo(Location other) {

        if(this instanceof Visitable && other instanceof Visitable){
            if(((Visitable) this).getOpeningTime() != null && ((Visitable) other).getOpeningTime() != null){
                return ((Visitable) this).getOpeningTime().compareTo(((Visitable) other).getOpeningTime());
            }else{
                System.out.println("Null data!!!..");
                return 0;
            }
        }else{
            System.out.println("Different interfaces, compering now by name!");
            if(this.getName() != null && other.getName() != null)
                return this.name.compareTo(other.name);
            else{
                System.out.println("Null name!");
                return 0;
            }
        }
    }
}
