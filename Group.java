package groupOfStudents;

import java.util.*;

abstract public class Group {

    public static Student[] formAGroup() {
        Student[] student = new Student[10];
        student[0] = new Student("Andrew", 20);
        student[1] = new ContractStudent("Anna", 19, 15000d);
        student[2] = new Student("Eugene", 19);
        student[3] = new Student("Gregory", 22);
        student[4] = new ContractStudent("John", 21, 15000d);
        student[5] = new ContractStudent("Helen", 20, 15000d);
        student[6] = new ContractStudent("Stephan", 20, 15000d);
        student[7] = new Student("Natalie", 19);
        student[8] = new Student("Bill", 21);
        student[9] = new Student("Jacob", 20);
        return student;
    }

    public static ContractStudent[] selectContractStudent(Student[] student) {
        List<ContractStudent> listOfContractStudent = new LinkedList<ContractStudent>();
        for (int i = 0; i < student.length; i++) {
            if (student[i] instanceof ContractStudent) {
                listOfContractStudent.add((ContractStudent) student[i]);
            }
        }
        ContractStudent[] contractStudent = {};
        contractStudent = listOfContractStudent.toArray(new ContractStudent[listOfContractStudent.size()]);
        return contractStudent;
    }
}