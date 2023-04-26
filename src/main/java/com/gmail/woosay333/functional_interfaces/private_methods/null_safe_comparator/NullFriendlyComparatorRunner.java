package com.gmail.woosay333.functional_interfaces.private_methods.null_safe_comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

public class NullFriendlyComparatorRunner {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(null);
        integerList.add(-3);
        integerList.add(-25);
        integerList.add(67);
        integerList.add(21);
        integerList.add(54);
        integerList.add(null);
        integerList.add(78);
        integerList.add(null);
        integerList.add(3);
        integerList.add(null);
        integerList.add(null);
        integerList.add(354);

        Comparator<Integer> comparator = Comparator.naturalOrder();

        comparator = NullFriendlyComparator.rangeNullFirst(comparator);

        integerList.sort(comparator);

        out.println(integerList);
    }

}
