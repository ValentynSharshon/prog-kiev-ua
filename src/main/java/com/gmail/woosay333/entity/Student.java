package com.gmail.woosay333.entity;

import com.gmail.woosay333.enums.Gender;

public class Student extends Human {

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
    public String toString() {
        return "Student {" +
                "name = " + getName() +
                ", lastName = " + getLastName() +
                ", id = " + id +
                ", groupName = '" + groupName + '\'' +
                '}';
    }

}
