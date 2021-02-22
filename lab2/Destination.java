package com.company;

public class Destination{
    private int demand;
    private String name;

    void setName(String name){
        this.name = name;
    }

    void setDemand(int demand){
        this.demand = demand;
    }

    int getDemand(){
        return this.demand;
    }

    String getName(){
        return this.name;
    }

    public String toString() {
        return String.format("I can demand: " + getDemand() + " units in " + getName());
    }
}
