package com.gmail.woosay333.hw.comparator;

import com.gmail.woosay333.hw.entity.Student;

import java.util.Comparator;

public class SortStudentsByLastName implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getLastName().compareTo(student2.getLastName());
    }

}
