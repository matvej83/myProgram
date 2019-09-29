package groupOfStudents;

public class ContractStudent extends Student {

    private double contractValue;

    public ContractStudent(String name, int age, double contractValue) {
        super(name, age);
        this.contractValue = contractValue;
    }

    public double getContractValue() {
        return contractValue;
    }

}
