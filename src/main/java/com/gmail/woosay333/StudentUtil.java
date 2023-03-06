package com.gmail.woosay333;

import com.gmail.woosay333.entity.Group;
import com.gmail.woosay333.entity.Student;
import com.gmail.woosay333.enums.Gender;
import com.gmail.woosay333.exceptions.GroupOverflowException;

import java.util.Scanner;

import static java.lang.System.out;

public class StudentUtil {

    private StudentUtil() {
    }

    public static void createStudentAndAddToTheGroup(Group group) throws GroupOverflowException {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        out.println("Input student name:");
        student.setName(scanner.nextLine().trim());

        out.println("Input student last name:");
        student.setLastName(scanner.nextLine().trim());

        try {
            out.println("Input student gender (MALE, FEMALE):");
            student.setGender(Gender.valueOf(scanner.nextLine().toUpperCase().trim()));
        } catch (IllegalArgumentException ex) {
            out.println("Gender not found, MALE and FEMALE available only!");
            return;
        }

        out.println("Input student id:");
        student.setId(scanner.nextInt());

        group.addStudent(student);
    }
}
