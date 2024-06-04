package com.app.org;

class Worker extends Emp {
    private int hoursWorked;
    private double hourlyRate;

    public Worker(int id, String name, String deptId, double basic, int hoursWorked, double hourlyRate) {
        super(id, name, deptId, basic);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double computeNetSalary() {
        return getBasic() + (hoursWorked * hourlyRate);
    }

    @Override
    public String toString() {
        return "Worker [id=" + getId() + ", name=" + getName() + ", deptId=" + getDeptId() + ", basic=" + getBasic() + ", hoursWorked=" + hoursWorked + ", hourlyRate=" + hourlyRate + "]";
    }
}