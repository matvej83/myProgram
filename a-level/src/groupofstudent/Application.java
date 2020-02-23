package groupofstudent;

import java.util.*;

/**
 * This program is a part of home task:
 * Realise 3 classes: Group, Student, ContractStudent. ContractStudent extends Student class. Student contains
 * name (String) and age (int).
 * Group class must contains array of Students (Student[] students).
 * Program must prints names and contract sums of all the contract students.
 * (The way to create a group isn't important).
 * You can use methods overriding or downcast.
 */
public class Application {
    public static void main(String[] args) {
        ContractStudent[] contractStudents;
        contractStudents = Arrays.copyOf(Group.selectContractStudent(Group.formAGroup()), Group.selectContractStudent(Group.formAGroup()).length);
        for (int i = 0; i < contractStudents.length; i++) {
            System.out.print("Student name: " + contractStudents[i].getName() + ". Contract value: ");
            System.out.printf("%.2f", contractStudents[i].getContractValue());
            System.out.println();
        }
    }
}