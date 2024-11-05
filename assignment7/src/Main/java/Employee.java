package Main.java;

public abstract class Employee {
    protected String employeeName;
    protected int id;
    protected String DepartmentName;
    protected String Role;

    public Employee(String employeeName, int id, String DepartmentName, String Role) {
        this.employeeName = employeeName;
        this.id = id;
        this.DepartmentName = DepartmentName;
        this.Role = Role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return id;
    }

    public String getEmployeeDeptName() {
        return DepartmentName;
    }

    public String getEmployeeRole() {
        return Role;
    }

    public abstract double getBasicSalary();

    public abstract double getBonus();

    public abstract double getCompensation();

    public double getTotalSalary() {
        return getBasicSalary() + getBonus() + getCompensation();
    }
}
