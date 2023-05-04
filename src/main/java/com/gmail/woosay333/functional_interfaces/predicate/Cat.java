package com.gmail.woosay333.functional_interfaces.predicate;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

    private String name;
    private int age;

    public Cat() {
        super();
    }

    public Cat(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Cat other = (Cat) obj;

        return age == other.getAge() && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Cat other) {
        if (other == null) {
            throw new NullPointerException();
        }

        if (age > other.age) {
            return 1;
        }

        if (age < other.age) {
            return -1;
        }

        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Cat [name=" + name + ", age=" + age + "]";
    }

}
