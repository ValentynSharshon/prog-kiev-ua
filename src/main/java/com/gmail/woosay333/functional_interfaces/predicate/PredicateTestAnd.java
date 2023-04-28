package com.gmail.woosay333.functional_interfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.out;

public class PredicateTestAnd {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(-1, 4, 5, 0, -2));

        numbers.removeIf(integer -> tests(integer, int1 -> int1 < 0, int2 -> int2 % 2 == 0));

        numbers.forEach(out::println);
    }

    private static <T> boolean tests(T t, Predicate<T> pr1, Predicate<T> pr2) {
        Predicate<T> resultPr = pr1.and(pr2);
        return resultPr.test(t);
    }

}
