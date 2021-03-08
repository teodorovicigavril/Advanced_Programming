package com.company;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private String name;
    private ArrayList<School> rankStudent;

    public Student(String name){
        this.rankStudent = new ArrayList<School>();
        this.name = name;
        this.rankStudent = null;
    }
    public Student() {
        this.rankStudent = new ArrayList<School>();
        this.name = "";
        this.rankStudent = null;
    }

    public Student(String name, ArrayList<School> rankStudent) {
        this.rankStudent = new ArrayList<School>();
        this.name = name;
        this.rankStudent = rankStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRankStudent(ArrayList<School> rankStudent) {
        this.rankStudent = rankStudent;
    }

    public String getName() {
        return name;
    }

    public ArrayList<School> getRankStudent() {
        return rankStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rankStudent=" + rankStudent +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        if(other instanceof Student){
            if(name.equals(other.name))
                return 1;
        }
        return -1;
    }

}
