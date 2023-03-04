package com.gmail.woosay333;

import com.gmail.woosay333.entity.Group;
import com.gmail.woosay333.entity.Student;
import com.gmail.woosay333.enums.Gender;
import com.gmail.woosay333.exceptions.GroupOverflowException;
import com.gmail.woosay333.exceptions.StudentNotFoundException;

import static java.lang.System.out;

public class Runner {

    public static void main(String[] args) {
        Group group = new Group("MT-5", 10);

        try {
            group.addStudent(new Student("Ron", "Garrison", Gender.MAIL, 0, group.getGroupName()));
            group.addStudent(new Student("Garry", "Stun", Gender.MAIL, 1, group.getGroupName()));
            group.addStudent(new Student("Rita", "Clark", Gender.FEMALE, 2, group.getGroupName()));
            group.addStudent(new Student("Kevin", "Stamp", Gender.MAIL, 3, group.getGroupName()));
            group.addStudent(new Student("Kim", "Pristel", Gender.MAIL, 4, group.getGroupName()));

            out.println(group.searchStudentByLastName("Clark"));
            out.println(group.removeStudentById(2));
        } catch (GroupOverflowException | StudentNotFoundException ex) {
            out.println(ex.getMessage());
        }

        out.println(group);
    }

}
