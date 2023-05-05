package com.gmail.woosay333.functional_interfaces.comparator.homework.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/*
 * Создайте реализацию Comparator<Integer> для сортировки списка целых чисел.
 * Но сравнение должно выполняться на основание суммы первой и последней цифры числа.
 * Т.е например список чисел подобного вида [62, 2000, 306, 55]
 * должен быть отсортирован как [2000, 62, 306, 55].
 * */
public class FirstLastDigitsSumComparator {

    private FirstLastDigitsSumComparator() {
    }

    public static void sort(List<Integer> integerList) {
        Comparator<Integer> comparator = Comparator.comparingInt(FirstLastDigitsSumComparator::getSumOfFirstAndLastDigits);

        integerList.sort(comparator);
    }

    private static Integer getSumOfFirstAndLastDigits(Integer number) {
        int msd = 0;
        int sum = number % 10;
        int counter = 0;
        while (number > 0) {
            msd = number % 10;
            number /= 10;
            counter++;
        }
        return counter == 1 ? sum : sum + msd;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(62, 2000, 306, 55, 11, 1, -2, -23));
        out.println(list);

        sort(list);
        out.println(list);
    }
}
