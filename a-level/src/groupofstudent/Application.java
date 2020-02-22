package groupofstudent;

import java.util.*;

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