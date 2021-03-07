package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    //Optional
    public void displayVisitableNotPayableLocations() {
        System.out.println("Location that are visitable and not payable, sorted by opening hour: ");
        ArrayList<Location> justVisitable = new ArrayList<Location>();
        for (int i = 0; i < nodes.size(); i++) {
            if(getNodes().get(i) instanceof Visitable && !(getNodes().get(i) instanceof Payable))
                justVisitable.add(getNodes().get(i));
        }
        Collections.sort(justVisitable);
        for(int i = 0; i < justVisitable.size(); i++){
            System.out.println(justVisitable.get(i).getName());
        }
    }
}
