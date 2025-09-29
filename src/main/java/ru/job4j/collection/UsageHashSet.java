package ru.job4j.collection;

import java.util.HashSet;
//  Добавьте в коллекцию autos марки машин: Lada, BMW, Volvo, Toyota.
public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");

        for (String car : autos) {
            System.out.println(car);
        }
    }
}