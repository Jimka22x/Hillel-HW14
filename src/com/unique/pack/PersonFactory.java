package com.unique.pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonFactory {

    public static final Random RANDOM = new Random();
    private static final String firstNames = "Иван Василий Егор";
    private static final String lastNames = "Кириенко Жданов";
    private final List<Person> personList = new ArrayList<>();

    public PersonFactory() {
    }

    public List<Person> generatePersonList(int count) {
        for (int i = 0; i < count; i++) {
            Person person = createPerson();
            personList.add(person);
        }
        return personList;
    }

    private Person createPerson() {
        String[] firstNamesArray = firstNames.split("\\s");
        String[] lastNamesArray = lastNames.split("\\s");
        String firstName = firstNamesArray[RANDOM.nextInt(firstNamesArray.length)];
        String lastName = lastNamesArray[RANDOM.nextInt(lastNamesArray.length)];
        double height = generateHeight();
        double weight = generateWeight(height);
        int age = generateAge(height);
        return new Person(firstName, lastName, age, weight, height);
    }

    private double generateHeight() {
        double start = 50;
        double end = 200;
        double random = RANDOM.nextDouble();
        double result = start + (random * (end - start));
        return Math.round(result * 10) / 10.0;
    }

    private double generateWeight(double height) {
        // Согласно ндексу Ноордена. Нормальная масса тела = рост[см] • 0,42 (сделаю коэф. 0.32 - 0.52)
        double weightIndex = (RANDOM.nextInt(21) + 32) / 100.0;
        return Math.round((height * weightIndex * 10)) / 10.0;
    }

    private int generateAge(double height) {
        if (height < 75) {
            return RANDOM.nextInt(1) + 1;
        } else if (height < 100) {
            return RANDOM.nextInt(2) + 3;
        } else if (height < 125) {
            return RANDOM.nextInt(6) + 6;
        } else if (height < 150) {
            return RANDOM.nextInt(5) + 11;
        } else {
            return RANDOM.nextInt(86) + 15;
        }
    }
}
