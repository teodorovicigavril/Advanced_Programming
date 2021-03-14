package com.company;

import com.github.javafaker.Faker;

import javax.sound.midi.Soundbank;
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
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        students[0].setScore(10);
        students[1].setScore(7);
        students[2].setScore(8);
        students[3].setScore(9);

        //Testing Faker
/*
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449

        System.out.println(name);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(streetAddress);
 */
        /*
        Faker faker = new Faker();
        students[0].setName(faker.name().fullName());
        students[1].setName(faker.name().fullName());
        students[2].setName(faker.name().fullName());
        students[3].setName(faker.name().fullName());

        schools[0].setName(faker.name().fullName());
        schools[1].setName(faker.name().fullName());
        schools[2].setName(faker.name().fullName());
*/
        //students[1].setName("A1");

        List<Student> studentList = new LinkedList<Student>();
        studentList.addAll( Arrays.asList(students) );

        //Collections.sort(studentList, Comparator.comparing(Student::getScore));
        Collections.sort(studentList);

        Set<School> schools1 = new TreeSet<School>();
        for (School s : schools) {
            schools1.add(s);
        }

        System.out.println(studentList.toString());
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

        System.out.println("-------to string---------");
        System.out.println(stdPrefMap.toString());
        System.out.println(schPrefMap.toString());
        System.out.println("-------to string---------");

        // Creez liste particulare de studenti si scoli pentru mai multe teste
        // acum targetStuds contine toti studentii, iar targetScool toate scolile.
        List<Student> targetStuds = Arrays.asList(students);
        List<School> targetSchools = Arrays.asList(schools[0], schools[1], schools[2]);

        System.out.println("Students who find acceptable in targetSchools");
        targetStuds.stream().filter(std -> stdPrefMap.get(std).containsAll(targetSchools)).forEach(System.out::println);

        System.out.println("----");
        Student std = students[0];
        System.out.println("Schools from targetStuds that have " + std.getName() + " as top preference");
        targetSchools.stream().filter(school -> schPrefMap.get(school).stream().findFirst().orElse(null).equals(std)).forEach(System.out::println);

        Problem problem = new Problem(stdPrefMap,schPrefMap);
        Solution solution = new Solution(problem);

            // Choose only one of the following, we loose data in function, or make a copy :D
        //solution.matchingBasedByStudScore();
        solution.stableMarriage();
    }

}
