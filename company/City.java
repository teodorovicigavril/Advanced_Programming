package com.company;

import java.util.ArrayList;

public class City {
    private ArrayList<Location> nodes;

    public City() {
        this.nodes = new ArrayList<>();
    }

    public City(ArrayList<Location> nodes) {
        this.nodes = new ArrayList<>();
        this.nodes = nodes;
    }

    public ArrayList<Location> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Location> nodes) {
        this.nodes = nodes;
    }

    //… constructors, getters, setters
    public void addLocation(Location node) {
        nodes.add(node);
    }

    //… toString, etc.

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}
