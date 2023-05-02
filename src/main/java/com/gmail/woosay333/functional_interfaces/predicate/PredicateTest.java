package com.gmail.woosay333.functional_interfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.out;

public class PredicateTest {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 4);
        Cat cat5 = new Cat("Kuzia", 2);
        List<Cat> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));

        cats.removeIf(cat -> cat.getAge() < 6);
        cats.forEach(out::println);

        cats.removeIf(cat -> catTest(cat, c -> c.getAge() > 8));
        cats.forEach(out::println);
    }

    private static <T extends Cat> boolean catTest(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

}
