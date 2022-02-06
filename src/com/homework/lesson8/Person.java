package com.homework.lesson8;


public class Person {
    @JsonName("name")
    String firstName = "Vasya";

    @JsonName("years")
    double age = 12;

    @JsonIgnore
    String password;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
