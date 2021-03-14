package com.company;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private String name;
    private ArrayList<School> rankStudent;
    private double score;

    private int vizitat = 0;

    public Student(String name){
        this.rankStudent = new ArrayList<School>();
        this.name = name;
        this.rankStudent = null;
        this.score = 0;
    }
    public Student() {
        this.rankStudent = new ArrayList<School>();
        this.name = "";
        this.rankStudent = null;
        this.score = 0;
    }

    public Student(String name, ArrayList<School> rankStudent) {
        this.rankStudent = new ArrayList<School>();
        this.name = name;
        this.rankStudent = rankStudent;
        this.score = 0;
    }

    public void setVizitat(int vizitat) {
        this.vizitat = vizitat;
    }

    public int getVizitat() {
        return vizitat;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
                ", score=" + score +
                ", vizitat=" + vizitat +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        if(this.score < other.score) return 1;
        if(this.score > other.score) return -1;
        return 0;
    }

}
