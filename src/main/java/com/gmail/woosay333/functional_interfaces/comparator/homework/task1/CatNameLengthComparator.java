package com.gmail.woosay333.functional_interfaces.comparator.homework.task1;

import com.gmail.woosay333.functional_interfaces.predicate.Cat;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;

/*
 * С помощью реализации Comparator<Cat> отсортируйте массив Cat
 * в порядке возрастания длинны имени.
 * Т.е. сначала должны идти коты чье имя самое короткое.
 * */
public class CatNameLengthComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Umka", 12);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 8);
        Cat cat4 = new Cat("Timka", 5);
        Cat cat5 = new Cat("Kuzia", 2);

        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4, cat5};

        Arrays.sort(cats, new CatNameLengthComparator());

        for (Cat cat : cats) {
            out.println(cat);
        }
    }
}
