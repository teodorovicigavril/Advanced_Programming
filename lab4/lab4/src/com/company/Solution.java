package com.company;

import java.util.*;


public class Solution extends Problem {
    private Problem problem;
    private int numberStudends;
    private int numberSchools;

    public Solution(Problem problem) {
        this.problem = new Problem();
        this.problem = problem;
        this.numberStudends = getProblem().getStdPrefMap().size();
        this.numberSchools = getProblem().getSchPrefMap().size();
    }

    public Solution(Map<Student, List<School>> stdPrefMap, Map<School, List<Student>> schPrefMap, Problem problem) {
        super(stdPrefMap, schPrefMap);
        this.problem = new Problem();
        this.problem = problem;
        this.numberSchools = getProblem().getStdPrefMap().size();
        this.numberSchools = getProblem().getSchPrefMap().size();
    }

    public void setNumberStudends(int numberStudends) {
        this.numberStudends = numberStudends;
    }

    public void setNumberSchools(int numberSchools) {
        this.numberSchools = numberSchools;
    }

    public int getNumberStudends() {
        return numberStudends;
    }

    public int getNumberSchools() {
        return numberSchools;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "problem=" + problem +
                '}';
    }

    public void matchingBasedByStudScore() {

        ArrayList<Map<Student, School>> matchingList = new ArrayList<>();

        for (int i = 0; i < problem.getStdPrefMap().size(); i++) {
            Student currentStudent = maxScoreStudentOnce();

            Map<Student, School> matching = new HashMap<Student, School>();
            for (int j = 0; j < problem.getStdPrefMap().get(currentStudent).size(); j++) {
                if (problem.getStdPrefMap().get(currentStudent).get(j).getCapacity() != 0) {
                    matching.put(currentStudent, problem.getStdPrefMap().get(currentStudent).get(j));
                    problem.getStdPrefMap().get(currentStudent).get(j).setCapacity(problem.getStdPrefMap().get(currentStudent).get(j).getCapacity() - 1);
                    break;
                }
            }
            matchingList.add(matching);
        }
        //System.out.println(matchingList.toString());
        System.out.println("An matching algorithm based by score of students: ");
        System.out.print("[ ");
        for (int i = 0; i < matchingList.size(); i++) {
            for (Map.Entry<Student, School> entry : matchingList.get(i).entrySet()) {
                Student key = entry.getKey();
                School value = entry.getValue();

                System.out.print("( " + key.getName() + " : " + value.getName() + " ) ");
            }
        }
        System.out.println(" ]");
    }

    public Student maxScoreStudentOnce() {
        double score = 0;
        Student max = new Student();

        for (Student std : problem.getStdPrefMap().keySet()) {
            if (std.getVizitat() == 0)
                if (std.getScore() > score) {
                    score = std.getScore();
                    max = std;
                }
        }
        max.setVizitat(1);
        return max;
    }

    // -------------------------------------------------------------//

    // This function returns true if student
    // 'w' prefers school 'm1' over man 'm'
    public boolean wPrefersM1OverM_ ( Student w, School m, School m1)
    {
        // Check if w prefers m over m1

        List<School> aux = problem.getStdPrefMap().get(w);
        for(School std: aux){
            if(std == m1)
                return true;
            if(std == m)
                return false;
        }
        return false;
    }

    public void stableMarriage (){


        HashMap<Student, School> parteners = new HashMap<>();
        int freeCount = getNumberStudends();

        // While there are free students, that have no school assigned
        while (freeCount > 0) {


            // Pick the first free school
            School sch = new School();
            for (School aux : problem.getSchPrefMap().keySet())
                if (aux.getVizitat() == 0) {
                    sch = aux;
                    break;
                }

            // One by one go to all student
            // according to sch's preferences.
            for (Student std : problem.getSchPrefMap().get(sch)) {
                Student s = std;
                if (sch.getVizitat() == 0) {

                    // The student of preference is free,
                    // w and m become pair (for now, it can change later)
                    if (s.getVizitat() == 0) {

                        parteners.put(s, sch);

                        // If there is no more space in the school then
                        // sch became unavabile
                        sch.setCapacity(sch.getCapacity() - 1);
                        if (sch.getCapacity() == 0)
                            sch.setVizitat(1);
                        s.setVizitat(1);

                        // Student assgined to pair so we exclude him from now
                        freeCount--;

                    } else
                    {
                        School m1 = parteners.get(s);

                        // Choosing the school with biggest preference
                        if (wPrefersM1OverM_(s, sch, m1) == false) {
                            parteners.put(s, sch);
                            s.setVizitat(1);
                            sch.setVizitat(0);
                            sch.setCapacity(sch.getCapacity() + 1);
                            m1.setVizitat(0);
                        }
                    }
                }
                else
                    break;
            }
        }

        //System.out.println(parteners.toString());
        System.out.println("An stable matching based by Gale Shapley algorithm: ");
        System.out.print("[ ");
            for (Map.Entry<Student, School> entry : parteners.entrySet()) {
                Student key = entry.getKey();
                School value = entry.getValue();
                System.out.print("( " + key.getName() + " : " + value.getName() + " ) ");
            }
        System.out.println(" ]");
    }

}