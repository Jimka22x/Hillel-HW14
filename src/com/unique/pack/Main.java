package com.unique.pack;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
//        1) В Дз11 был метод который возвращает 100 случайных людей.
//          Написать метод который который удалит из этого списка добликаты по имени и фамилии.
//          Т.е. останутся только люди с уникальной комбинайцией имя+фамилия. Остальные поля в расчет не берутся.
        PersonFactory factory = new PersonFactory();
        List<Person> personList = factory.generatePersonList(100);
        System.out.println("До очистки дубликатов:    " + personList);
        Set<Person> personSet = new LinkedHashSet<>(personList);
        personList.clear();
        personList.addAll(personSet);
        System.out.println("После очистки дубликатов: " + personList);
    }
}