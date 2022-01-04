package com.homework.lesson7;

public class PetAnimal extends Animal {
    @Override
    String getFavoriteMeal() {
        return "Молоко";
    }
}

class Cat extends PetAnimal {
    @Override
    String getFavoriteMeal() {
        return "Колбаса";
    }

    @Override
    public int hashCode() {
        return super.name.hashCode() * 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Dog)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Dog dog = (Dog) obj;
        return this.name == dog.name;
    }

}

class Dog extends PetAnimal {
    @Override
    String getFavoriteMeal() {
        return "Курица";
    }

    @Override
    public int hashCode() {
        return super.name.hashCode() * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Dog)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Dog dog = (Dog) obj;
        return this.name == dog.name;
    }
}