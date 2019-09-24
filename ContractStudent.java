package groupOfStudents;

import java.sql.SQLOutput;

public class ContractStudent extends Student {
    private double contractValue;

    public ContractStudent(String name, int age, double contractValue) {
        super(name, age);
        this.contractValue = contractValue;
    }

    public double getContractValue() {
        return contractValue;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    @Override
    public void display() {
        System.out.print("Student name: " + this.getName()+ ". Contract value: ");
        System.out.printf("%.2f",  this.contractValue);
        System.out.println();
    }
}
