package com.gmail.woosay333.functional_interfaces.function.homework;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;

public class FunctionUtil {

    private FunctionUtil() {
    }

    /*
     * С помощью реализации Function<Integer[],Integer> и реализации Predicate<Integer> (да нужно
     * вспоминать и предыдущую лекцию ☺) реализуйте функцию которая вернет количество простых
     * чисел в массиве целых чисел. Например [5,6,7,8,9,10] => 2
     * */
    public static long getPrimeNumbersAmount(int[] array) {
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

    /*
     * Опишите такую реализацию Function<String, Integer> которая вернет количество согласных букв в
     * строке текста.
     * */
    public static Integer consonantsStringAmount(String str) {
        ToIntFunction<String> function = s -> {
            int counter = 0;
            Character[] characters = {'a', 'e', 'i', 'o', 'u'};

            for (Character character : str.toCharArray()) {
                for (Character ch : characters) {
                    if (character.equals(ch)) {
                        counter += 1;
                    }
                }
            }

            return counter;
        };

        return function.applyAsInt(str);
    }

    /*
     * Используя композицию функций реализуйте функцию которая вернет сумму кодов каждого
     * символа в произвольной строке.
     * */
    public static String getSumOfCharacterUnicodeCodes(String str) {
        Function<String, char[]> toCharArrayFunction = String::toCharArray;
        Function<char[], Integer> integerFunction = chars -> {
            int sum = 0;

            for (char ch : chars) {
                sum += ch;
            }

            return sum;
        };

        Function<String, Integer> composeFunction = toCharArrayFunction.andThen(integerFunction);
        return String.valueOf(composeFunction.apply(str));
    }

    /*
     * Опишите такую реализацию BiFunction<String,String,String[]>
     * которая вернет в виде массива слова которые одновременно присутствуют и в первой строке
     * и во второй (слова разделены пробелами).
     * Например text1 = «Hello Java», text2 = «Hello Python»
     * в результате должен быть массив вида [«Hello»].
     * */
    public static String[] getWordsSimultaneouslyPresentInStrings(String str1, String str2) {
        BiFunction<String, String, String[]> biFunction = (s1, s2) -> {
            List<String> resultList = new ArrayList<>();

            for (String str1Item : s1.split("\\s")) {
                for (String str2Item : s2.split("\\s")) {
                    if (str2Item.equals(str1Item)) {
                        resultList.add(str2Item);
                    }
                }
            }

            return resultList.toArray(new String[0]);
        };

        return biFunction.apply(str1, str2);
    }

    /*
     * Используя примитивную специализацию Function реализуйте функционал
     * который на основе объекта типа java.util.Calendar вернет целое число
     * значение которого равно году хранимому в Calendar.
     * */
    public static int getYearFromCalendar(Calendar calendar) {
        ToIntFunction<Calendar> toIntFunction = value -> value.get(Calendar.YEAR);

        return toIntFunction.applyAsInt(calendar);
    }

}
