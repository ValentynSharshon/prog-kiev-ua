package com.gmail.woosay333.entity;

import com.gmail.woosay333.enums.Gender;

import java.util.StringJoiner;

public class Student extends Human implements CSVConverter {

    private int id;
    private String groupName = "Unknown";

    public Student() {

    }

    public Student(String name, String lastName, Gender gender, int id) {
        super(name, lastName, gender);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toCSVString() {
        return new StringJoiner(";")
                .add(getName())
                .add(getLastName())
                .add(getGender().toString())
                .add(String.valueOf(getId()))
                .add(getGroupName())
                .toString();
    }

    @Override
    public Student fromCSVString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty!");
        }

        String[] array = str.split("\\W+");
        return new Student(array[0], array[1],
                Gender.valueOf(array[2].toUpperCase().trim()),
                Integer.parseInt(array[3]));
    }

    @Override
    public String toString() {
        return "Student {" +
                "name = " + getName() +
                ", lastName = " + getLastName() +
                ", id = " + id +
                ", groupName = '" + groupName + '\'' +
                '}';
    }

}
