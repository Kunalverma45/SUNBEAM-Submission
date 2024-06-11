package tester;

public class Worker extends Employee {
    private static final double WORKER_ALLOWANCE = 0.1;

    public Worker(String name, double basicSalary) {
        super(name, basicSalary);
    }

    @Override
    public double calculateNetSalary() {
        return getBasicSalary() + (getBasicSalary() * WORKER_ALLOWANCE);
    }

    @Override
    public String toString() {
        return "Worker: " + super.toString() + ", Net Salary: " + calculateNetSalary();
    }
}
