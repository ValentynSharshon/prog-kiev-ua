package com.gmail.woosay333.functional_interfaces.comparable.homework.task1;

import java.util.Objects;

/*
 * Создайте класс прямоугольник, с двумя полями - длинной и высотой прямоугольника.
 * Задайте отношение естественного порядка для объектов этого класса
 * (реализуйте интерфейс Comparable) на основании площади этого прямоугольника.
 * Используйте эту реализацию для сортировки массива объектов класса прямоугольник.
 * */
public class Rectangle implements Comparable<Rectangle> {

    private final double length;
    private final double height;

    public Rectangle(double length, double height) {
        super();
        this.length = length;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public double getSquare() {
        return height * length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle other = (Rectangle) obj;
        return Double.compare(other.length, length) == 0 && Double.compare(other.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }

    @Override
    public int compareTo(Rectangle other) {
        if (other == null) {
            throw new NullPointerException();
        }

        return Double.compare(getSquare(), other.getSquare());
    }

    public static Rectangle getMax(Rectangle[] rectangles) {
        if (rectangles.length == 0) {
            return null;
        }

        Rectangle max = rectangles[0];

        for (Rectangle item : rectangles) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "length = " + length +
                ", height = " + height +
                ", square = " + getSquare() +
                '}';
    }

}
