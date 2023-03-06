package com.gmail.woosay333.entity;

import com.gmail.woosay333.exceptions.GroupOverflowException;
import com.gmail.woosay333.exceptions.StudentNotFoundException;

public class Group {

    private String groupName;
    private Student[] students;

    public Group() {
    }

    public Group(String groupName, int groupLength) {
        this.groupName = groupName;
        this.students = new Student[groupLength];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (student == null) {
            throw new IllegalArgumentException("Can`t add student, student is null!");
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }

        throw new GroupOverflowException("Group is full!");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }

        throw new StudentNotFoundException("Student " + lastName + " not found!");
    }

    public boolean removeStudentById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder group = new StringBuilder();
        group.append("Group: ").append(groupName).append(System.lineSeparator());

        for (Student student : students) {
            if (student != null) {
                group.append(student).append(System.lineSeparator());
            }
        }

        return group.toString();
    }

}
