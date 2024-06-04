package com.app.org;

public class Emp {
    private int id;
    private String name;
    private String deptId;
    private double basic;

    public Emp(int id, String name, String deptId, double basic) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.basic = basic;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeptId() {
        return deptId;
    }

    public double getBasic() {
        return basic;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", deptId=" + deptId + ", basic=" + basic + "]";
    }
}