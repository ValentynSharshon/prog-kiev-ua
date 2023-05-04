package com.gmail.woosay333.functional_interfaces.comparable.homework.task2;

public class ComparableUtil {

    private ComparableUtil() {
    }


    public static <T extends Comparable<T>> T getMax(T[] array) {
        if (array.length == 0) {
            return null;
        }

        T max = array[0];

        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

}
