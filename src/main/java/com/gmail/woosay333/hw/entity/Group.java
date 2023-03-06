package com.gmail.woosay333.hw.entity;

import com.gmail.woosay333.hw.comparator.SortStudentsByLastName;
import com.gmail.woosay333.hw.exceptions.GroupOverflowException;
import com.gmail.woosay333.hw.exceptions.StudentNotFoundException;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

    private String groupName;
    private final Student[] studentsGroup;

    public Group(int groupLength) {
        this.groupName = "Unknown";
        this.studentsGroup = new Student[groupLength];
    }

    public Group(String groupName, int groupLength) {
        this.groupName = groupName;
        this.studentsGroup = new Student[groupLength];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudentsGroup() {
        return studentsGroup;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (student == null) {
            throw new IllegalArgumentException("Can`t add student, student is null!");
        }

        for (int i = 0; i < studentsGroup.length; i++) {
            if (studentsGroup[i] == null) {
                studentsGroup[i] = student;
                student.setGroupName(groupName);
                return;
            }
        }

        throw new GroupOverflowException("Group is full!");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : studentsGroup) {
            if (student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }

        throw new StudentNotFoundException("Student " + lastName + " not found!");
    }

    public boolean removeStudentById(int id) {
        for (int i = 0; i < studentsGroup.length; i++) {
            if (studentsGroup[i].getId() == id) {
                studentsGroup[i] = null;
                return true;
            }
        }

        return false;
    }

    public void sortStudentsByLastName() {
        Arrays.sort(studentsGroup, Comparator.nullsFirst(new SortStudentsByLastName()));
    }

    @Override
    public String toString() {
        StringBuilder group = new StringBuilder();
        group.append("Group: ").append(groupName).append(System.lineSeparator());

        for (Student student : studentsGroup) {
            if (student != null) {
                group.append(student).append(System.lineSeparator());
            }
        }

        return group.toString();
    }

}
