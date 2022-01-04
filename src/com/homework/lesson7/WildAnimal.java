package com.homework.lesson7;

public class WildAnimal extends Animal {
    @Override
    String getFavoriteMeal() {
        return "Мясо";
    }
}

class Wolf extends WildAnimal {
    @Override
    String getFavoriteMeal() {
        return "Овца";
    }

    @Override
    public int hashCode() {
        return super.name.hashCode();
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

class Fox extends WildAnimal {
    @Override
    String getFavoriteMeal() {
        return "Сыр";
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
