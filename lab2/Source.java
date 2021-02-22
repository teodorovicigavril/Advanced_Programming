package com.company;



public class Source{
    private int supply;
    private String name;
    private Main.SourceType type;

    void setType(Main.SourceType type){
        this.type = type;
    }

    Main.SourceType getType(){
        return this.type;
    }

    void setName(String name){
        this.name = name;
    }

    void setSupply(int supply){
        this.supply = supply;
    }

    int getSupply(){
        return this.supply;
    }

    String getName(){
        return this.name;
    }

    public String toString() {
        return String.format("I can supply: " + getSupply() + " units from " + getType() + " " + getName());
    }
}
