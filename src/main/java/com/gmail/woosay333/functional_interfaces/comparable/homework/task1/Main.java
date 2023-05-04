package com.gmail.woosay333.functional_interfaces.comparable.homework.task1;

import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        List<Rectangle> rectangles = List.of(
                new Rectangle(4.2, 3.4),
                new Rectangle(3.35, 1.4),
                new Rectangle(2.6, 2.1),
                new Rectangle(8.82, 2.21),
                new Rectangle(4.3, 3.4));

        rectangles.forEach(out::println);
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        rectangles.stream().sorted().forEach(out::println);
    }

}
