package com.gmail.woosay333.functional_interfaces.comparator.homework.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/*
 * Используя составной Comparator реализуйте в List<Integer> поиск числа
 * модуль которого наиболее близок к нулю.
 * Если встретятся два модуль которых одинаково близок к нулю(например 5 и -5)
 * то верните положительное значение.
 * */
public class NumberABSComparator {

    private NumberABSComparator() {
    }

    public static Integer getNumberWithClosestToZeroABSC(List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return -1;
        }

        Comparator<Integer> moduleComparator = Comparator.comparingInt(Math::abs);
        Comparator<Integer> numberComparator = (number1, number2) -> number2 - number1;

        return Collections.min(integerList, moduleComparator.thenComparing(numberComparator));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, -2, -5, 2));

        out.println(getNumberWithClosestToZeroABSC(list));
    }
}
