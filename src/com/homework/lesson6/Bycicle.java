package com.homework.lesson6;

import java.util.Objects;

public class Bycicle {
    private String modelName;
    private int maxSpeed;// (от 5 до 50км\ч);

    public Bycicle(String modelName, int maxSpeed) {
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bycicle bycicle = (Bycicle) o;
        return maxSpeed == bycicle.maxSpeed && Objects.equals(modelName, bycicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, maxSpeed);
    }

    @Override
    public String toString() {
        return "Bycicle{" +
                "modelName='" + modelName + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
