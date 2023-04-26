package com.gmail.woosay333.functional_interfaces.private_methods.null_safe_comparator;

import java.util.Comparator;

public interface NullFriendlyComparator {

    int NOT_NULL = 11;

    static <T> Comparator<T> rangeNullFirst(Comparator<T> unsafeComparator) {

        class NullSafeComparator implements Comparator<T> {
            @Override
            public int compare(T o1, T o2) {
                int compareResult = nullSafeCompare(o1, o2);
                if (compareResult != NOT_NULL) {
                    return compareResult;
                }
                return unsafeComparator.compare(o1, o2);
            }
        }

        return new NullSafeComparator();
    }

    private static <T> int nullSafeCompare(T first, T second) {
        if (first != null && second == null) {
            return 1;
        } else if (first == null && second != null) {
            return -1;
        } else if (first == null && second == null) {
            return 0;
        } else {
            return NOT_NULL;
        }
    }
}
