package Main.java;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return name;
    }

    /**
     * To add an employee to a department
     * 
     * @param employee- The employee to be added
     * @return boolean - true if employee added to a department successfuly
     *         otherwise false
     */
    public boolean joinEmployee(Employee employee) {
        if (employee.employeeName.isEmpty() || employee.id == 0) {
            System.out.println("Employee details are empty! Enter proper details");
            return false;
        }

        employees.add(employee);
        System.out.println("Employee added successfully");

        return true;

    }

    /**
     * To remove an employee from a department
     * 
     * @param employee - The employee to be removed
     * @return boolean- true if employee removed successfuly otherwise false
     */
    public boolean relieve(Employee employee) {
        if (employee.employeeName.isEmpty() || employee.id == 0) {
            System.out.println("Employee details are empty! Enter proper details");
            return false;
        }
        employees.remove(employee);
        System.out.println("Employee removed successfully");

        return true;

    }

    /**
     * To return the list of all employees present in a department
     * 
     * @return List of All employees of a department
     */
    public List<Employee> getEmployees() {
        return employees;
    }

}
