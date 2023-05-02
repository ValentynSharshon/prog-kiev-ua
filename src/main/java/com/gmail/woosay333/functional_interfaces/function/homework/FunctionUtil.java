package com.gmail.woosay333.functional_interfaces.function.homework;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class FunctionUtil {

    private FunctionUtil() {
    }

    /*
     * С помощью реализации Function<Integer[],Integer> и реализации Predicate<Integer> (да нужно
     вспоминать и предыдущую лекцию ☺) реализуйте функцию которая вернет количество простых
     чисел в массиве целых чисел. Например [5,6,7,8,9,10] => 2
     * */
    public static long getPrimeAmount(int[] array) {
        IntPredicate predicate1 = value -> value > 1;
        IntPredicate predicate2 = value -> {
            for (int i = 2; i <= value / 2; i++) {
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        };
        IntPredicate totalPredicate = predicate1.and(predicate2);

        return Arrays.stream(array).filter(totalPredicate).count();
    }

}
