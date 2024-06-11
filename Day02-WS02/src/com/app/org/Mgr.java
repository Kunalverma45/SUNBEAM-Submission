package com.app.org;

class Mgr extends Emp {
    private double performanceBonus;

    public Mgr(int id, String name, String deptId, double basic, double performanceBonus) {
        super(id, name, deptId, basic);
        this.performanceBonus = performanceBonus;
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    public double computeNetSalary() {
        return getBasic() + performanceBonus;
    }

    @Override
    public String toString() {
        return "Mgr [id=" + getId() + ", name=" + getName() + ", deptId=" + getDeptId() + 
                ", basic=" + getBasic() + ", performanceBonus=" + performanceBonus + "]";
    }
}