package com.homework.lesson11.lection;

import java.util.Set;

public class Student {
    private String name;
    private Set<Lection> lectionSet;

    public Student(String name, Set<Lection> lectionSet) {
        this.name = name;
        this.lectionSet = lectionSet;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getLectionSet() {
        return lectionSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lectionSet=" + lectionSet +
                '}';
    }
}
