package com.homework.lesson7;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Zoo {
    Set<WildAnimal> wildAnimalSet;
    Set<PetAnimal> petAnimalSet;

    public Zoo() {
        wildAnimalSet = fillCollectionWithWildAnimals(new HashSet<>());
        petAnimalSet = fillCollectionWithPetAnimals(new HashSet<>());
    }

    public Set<PetAnimal> fillCollectionWithPetAnimals(Set<PetAnimal> petAnimalSet) {
        int rand = new Random().nextInt(4) + 1;
        for (int i = 0; i < rand; i++) {
            PetAnimal petAnimal;
            int nextInt = new Random().nextInt(2);
            if (nextInt == 0) {
                petAnimal = new Cat();
            } else {
                petAnimal = new Dog();
            }
            petAnimal.name = "PetName" + new Random().nextInt();
            petAnimalSet.add(petAnimal);
        }
        return petAnimalSet;
    }

    public Set<WildAnimal> fillCollectionWithWildAnimals(Set<WildAnimal> wildAnimalSet) {
        int rand = new Random().nextInt(7) + 3;
        for (int i = 0; i < rand; i++) {
            WildAnimal wildAnimal;
            int nextInt = new Random().nextInt(2);
            if (nextInt == 0) {
                wildAnimal = new Wolf();
            } else {
                wildAnimal = new Fox();
            }
            wildAnimal.name = "WildName" + new Random().nextInt();
            wildAnimalSet.add(wildAnimal);
        }
        return wildAnimalSet;
    }

    private void printAnimalsFromCollection(Set<? extends Animal> animals) {
        animals.forEach(a -> System.out.println(a.name));
    }

    public void printAllAnimals() {
        printAnimalsFromCollection(wildAnimalSet);
        printAnimalsFromCollection(petAnimalSet);
    }
}
