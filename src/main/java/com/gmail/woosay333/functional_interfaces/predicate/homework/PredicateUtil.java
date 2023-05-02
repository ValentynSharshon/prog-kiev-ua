package com.gmail.woosay333.functional_interfaces.predicate.homework;

import com.gmail.woosay333.functional_interfaces.predicate.Cat;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateUtil {

    private PredicateUtil() {
    }

    /*
     * С помощью реализации Predicat<String> реализуйте удаление со списка строк
     * начинающихся с определенной буквы. Например удалить все строки которые начинаются
     * на букву F.
     * */
    public static void deleteStringsStartsWith(List<String> strings, char ch) {
        strings.removeIf(s -> s.startsWith(String.valueOf(ch)));
    }

    /*
     * Используя реализацию Predicate<String> реализуйте удаление со списка строк,
     * строки первая буква которых задается отдельным массивом символов.
     * Например если этот массив содержит ['h','a','t'] то со списка стоит удалить
     * все строки которые начинаются с этих букв.
     * */
    public static void deleteStringsStartWith(List<String> strings, char[] chars) {
        strings.removeIf(s -> {
            for (char ch : chars) {
                if (s.startsWith(String.valueOf(ch))) {
                    return true;
                }
            }
            return false;
        });
    }

    /*
     * Используя реализацию Preticate<Cat> (в качестве Cat взять класс используемый в лекции)
     * и методы для логических функций, реализуйте удаление из списка Cat котов возраст
     * которых меньше определенного значения (задается как параметр), а имя по алфавиту
     * идет после буквы (задается так же как параметр).
     * Например если первый параметр задан как 5, а второй как 'C'
     * то будет удален Cat [name=Timka, age=4], Cat [name=Kuzia, age=2].
     * */
    public static void deleteCats(List<Cat> cats, int age, char ch) {
        Predicate<Cat> pr1 = cat -> cat.getAge() < age;
        Predicate<Cat> pr2 = cat -> cat.getName().compareTo(String.valueOf(ch)) > 0;

        cats.removeIf(pr1.and(pr2));
    }

    /*
     * Используя реализацию BiPredicate<Integer, String> реализуйте
     * удаление из Map<Integer, String> всех пар ключ-значение
     * для которых длинна строки значения не равна ключу этого значения.
     * Например такая пара как {3: «Hello»} должна быть удалена
     * так как длинна «Hello» не равна 3, а пара вида {4: «Java»} останется.
     * */
    public static void deleteEntry(Map<Integer, String> map) {
        BiPredicate<Integer, String> predicate = (integer, str) -> str.length() != integer;

        map.entrySet().removeIf(entry -> predicate.test(entry.getKey(), entry.getValue()));
    }

    /*
     * Создайте такую реализацию IntPredicate которая будет возвращать true
     * в случае когда сумма цифр числа число четное. Например для 103 — вернет true,
     * так 1+0+3 = 4.
     * */
    public static IntPredicate isSumOfNumbersEven() {
        return value -> {
            int sum = 0;

            char[] charArray = String.valueOf(value).toCharArray();
            for (char ch : charArray) {
                sum += ch;
            }

            return sum % 2 == 0;
        };
    }

}
