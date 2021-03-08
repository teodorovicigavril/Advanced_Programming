package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        //System.out.println(students[0].getName());

        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);

        schools[0].setCapacity(1);
        schools[0].setCapacity(2);
        schools[0].setCapacity(2);

        //students[1].setName("A1");

        List<Student> studentList = new LinkedList<Student>();
        studentList.addAll( Arrays.asList(students) );

        Collections.sort(studentList, Comparator.comparing(Student::getName));

        //for(int i=0;i<4;i++)
         //   System.out.println(studentList.get(i).getName());

        Set<School> schools1 = new TreeSet<School>();
        for (School s : schools) {
            schools1.add(s);
        }

        //schools1.addAll( Arrays.asSet(schools) );
        //System.out.println(schools1.toString());

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schPrefMap = new LinkedHashMap<>();

        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        schPrefMap.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        System.out.println(stdPrefMap.toString());
        System.out.println(schPrefMap.toString());
    }
}
