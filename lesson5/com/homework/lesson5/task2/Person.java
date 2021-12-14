package com.homework.lesson5.task2;

public class Person {
    private String name;
    private Season favoriteSeason;

    public Person(String name, Season favoriteSeason) {
        this.name = name;
        this.favoriteSeason = favoriteSeason;
    }

    @Override
    public String toString() {
        return "Person{" +
                "имя='" + name + '\'' +
                ", сезон=" + favoriteSeason +'\'' +
                ", а игра=" + favoriteSeason.getGame().getDescription() +
                '}';
    }
}
