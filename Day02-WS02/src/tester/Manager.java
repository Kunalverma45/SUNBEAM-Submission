package tester;

public class Manager extends Employee {
    private static final double MANAGER_ALLOWANCE = 0.2;

    public Manager(String name, double basicSalary) {
        super(name, basicSalary);
    }

    @Override
    public double calculateNetSalary() {
        return getBasicSalary() + (getBasicSalary() * MANAGER_ALLOWANCE);
    }

    @Override
    public String toString() {
        return "Manager: " + super.toString() + ", Net Salary: " + calculateNetSalary();
    }
}
