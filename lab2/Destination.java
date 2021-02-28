package com.company;

import java.util.Objects;

public class Destination {
    private int demand;
    private String name;
    private int index;

    /**
     * Constructor pentru clasa Destination cu toti parametrii
     * @param demand numarul de cereri ale destinatiei
     * @param name numele destinatiei
     * @param index indexul din matricea de costuri, in cadrul coloanelor
     */
    public Destination(int demand, String name, int index) {
        this.demand = demand;
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDemand(int demand) {
        this.demand = demand;
    }

    int getDemand() {
        return this.demand;
    }

    String getName() {
        return this.name;
    }

    /*
    public String toString() {
        return String.format("I can demand: " + getDemand() + " units in " + getName());
    }
     */

    @Override
    public String toString() {
        return "Destination{" +
                "demand=" + demand +
                ", name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return getIndex() == that.getIndex() || Objects.equals(getName(), that.getName());
    }

}