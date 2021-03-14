package com.company;

import java.util.*;

public class Problem {
    private Map<Student, List<School>> stdPrefMap;
    private Map<School, List<Student>> schPrefMap;

    public Problem() {
        this.stdPrefMap = new HashMap<>();
        this.schPrefMap = new LinkedHashMap<>();
    }

    public Problem(Map<Student, List<School>> stdPrefMap, Map<School, List<Student>> schPrefMap) {
        this.stdPrefMap = new HashMap<>();
        this.schPrefMap = new LinkedHashMap<>();
        this.stdPrefMap = stdPrefMap;
        this.schPrefMap = schPrefMap;
    }

    public Map<Student, List<School>> getStdPrefMap() {
        return stdPrefMap;
    }

    public Map<School, List<Student>> getSchPrefMap() {
        return schPrefMap;
    }

    public void setStdPrefMap(Map<Student, List<School>> stdPrefMap) {
        this.stdPrefMap = stdPrefMap;
    }

    public void setSchPrefMap(Map<School, List<Student>> schPrefMap) {
        this.schPrefMap = schPrefMap;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "stdPrefMap=" + stdPrefMap +
                ", schPrefMap=" + schPrefMap +
                '}';
    }
}
