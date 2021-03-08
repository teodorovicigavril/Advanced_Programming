package com.company;

import java.util.ArrayList;

public class School implements Comparable<School>{
    private String name;
    private int capacity;
    private ArrayList<Student> rankSchool;

    public School(String name){
        this.rankSchool = new ArrayList<Student>();
        this.name = name;
        this.capacity = -1;
        this.rankSchool = null;
    }
    public School() {
        this.rankSchool = new ArrayList<Student>();
        this.name = "";
        this.capacity = -1;
        this.rankSchool = null;
    }

    public School(String name, int capacity, ArrayList<Student> rankSchool) {
        this.rankSchool = new ArrayList<Student>();
        this.name = name;
        this.capacity = capacity;
        this.rankSchool = rankSchool;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getRankSchool() {
        return rankSchool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRankSchool(ArrayList<Student> rankSchool) {
        this.rankSchool = rankSchool;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", rankSchool=" + rankSchool +
                '}';
    }

    @Override
    public int compareTo(School other) {
        if(other instanceof School){
            if(name.equals(other.name))
                return 1;
        }
        return -1;
    }
}
