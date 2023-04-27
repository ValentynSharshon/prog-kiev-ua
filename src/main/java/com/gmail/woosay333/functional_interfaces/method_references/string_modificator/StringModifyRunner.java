package com.gmail.woosay333.functional_interfaces.method_references.string_modificator;

import java.util.Arrays;
import java.util.function.Function;

import static java.lang.System.out;

public class StringModifyRunner {

    public static void main(String[] args) {
        String[] array = {"Hello", "java", "functional", "interface"};
        changeStringInArray(array, String::toUpperCase);
        out.println(Arrays.toString(array));

        changeStringInArray(array, value -> String.format("hello %s", value));
        out.println(Arrays.toString(array));

        Function<Integer, Character[]> function = functionComposition(StringModifyRunner::intToStr, StringModifyRunner::strToCharArray);
        Arrays.stream(function.apply(132546785)).sorted(Character::compareTo).forEach(character -> out.print(character + " "));
    }

    private static void changeStringInArray(String[] array, StringModify function) {
        for (int i = 0; i < array.length; i++) {
            array[i] = function.modify(array[i]);
        }
    }

    private static <F, S, R> Function<F, R> functionComposition(Function<F, S> f1, Function<S, R> f2) {

        class Composition {
            R comp(F t) {
                S temp = f1.apply(t);
                return f2.apply(temp);
            }
        }

        Composition composition = new Composition();
        return composition::comp;
    }

    private static String intToStr(Integer value) {
        return String.valueOf(value);
    }

    private static Character[] strToCharArray(String value) {
        return value.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
    }

}
