package Main.java;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Organisation organisation = new Organisation("Metacube", null);
        Payroll payroll = new Payroll();
        int idOfEmployee = 1;// represents the id of the employee to be added
        Scanner scanner = new Scanner(System.in);
        System.out.println("Payroll System for Organisation: " + organisation.getNameOfOrganisation());
        int choice;
        do {
            System.out.println("Select from the following Options:");
            System.out.println("1: Add a department");
            System.out.println("2: Add an employee to a department");
            System.out.println("3: Remove an employee from  a department");
            System.out.println("4: Get employees of a particular Department");
            System.out.println("5: Get all Employees");
            System.out.println("6: Generate payroll for all Employees");
            System.out.println("7: Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter department name: HR/ IT");
                    String deptName = scanner.nextLine();
                    Department department = null;
                    if (deptName.equalsIgnoreCase("HR"))
                        department = new HRDept();
                    else if (deptName.equalsIgnoreCase("IT"))
                        department = new ITDept();
                    else {
                        System.out.println("Please select a valid DepartmentName");
                    }

                    if (department != null && organisation.addDepartment(department)) {
                        System.out.println("Department added successfully");
                    }
                    break;
                case 2:
                    System.out.println("Enter department Name to add Employee in: HR/ IT");
                    String deptNamee = scanner.nextLine();
                    Department targetDept = organisation.getDepartmentByName(deptNamee);
                    if (targetDept != null) {
                        System.out.println("Enter Employee details: ");
                        System.out.println("Employee Name: ");
                        String employeeName = scanner.nextLine();
                        System.out.println("Enter employee type: Developer/Hr");
                        String employeeType = scanner.nextLine();
                        Employee employee = null;

                        if (employeeType.equalsIgnoreCase("DEVELOPER")) {
                            employee = new Developer(employeeName, idOfEmployee, deptNamee, employeeType);
                            idOfEmployee++;
                        } else if (employeeType.equalsIgnoreCase("HR")) {
                            employee = new HR(employeeName, idOfEmployee, deptNamee, employeeType);
                            idOfEmployee++;
                        } else {
                            System.out.println("Invalid employee type!");
                        }

                        if (employee != null && targetDept.joinEmployee(employee)) {
                            System.out.println("Employee added successfully");
                        }
                    } else {
                        System.out.println("department not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter department Name to remove Employee from: HR/ IT");
                    String depttName = scanner.nextLine();
                    Department targettDept = organisation.getDepartmentByName(depttName);
                    if (targettDept != null) {
                        //System.out.println(targettDept);
                        System.out.println("Enter employee Name to be deleted");
                        String employeeName = scanner.nextLine();
                        List<Employee> employeesOfDept = targettDept.getEmployees();////check
                        for(Employee e: employeesOfDept){
                            System.out.println(e.getEmployeeName());
                        }
                        for (Employee employee : employeesOfDept) {
                            if (employee.getEmployeeName().equals(employeeName)) {
                                targettDept.relieve(employee);
                                break;
                            }
                        }
                        System.out.println("Employee Name not found");

                    } else {
                        System.out.println("Invalid dept Name!Enter valid");
                    }
                    break;
                case 4:
                    System.out.println("Enter the Department you want employees of: HR/IT");
                    String dept = scanner.nextLine();
                    Department targetDeptt = organisation.getDepartmentByName(dept);
                    if (targetDeptt != null) {
                        System.out.println("Here are the details of the employees");
                        List<Employee> employees = targetDeptt.getEmployees();
                        for (Employee employee : employees) {
                            System.out.print(
                                    "Id: " + employee.getEmployeeId() + " Name: " + employee.getEmployeeName()
                                            + " Role: " + employee.getEmployeeRole());
                            System.out.println();
                        }

                    } else {
                        System.out.println("Invalid dept Name!Enter valid");
                    }
                    break;
                case 5:
                    System.out.println("Here are the details of all employees: ");
                    List<Employee> employees = organisation.getAllEmployees();
                    for (Employee emp : employees) {
                        System.out.print(
                                "Id: " + emp.getEmployeeId() + " Name: " + emp.getEmployeeName()
                                        + " Role: " + emp.getEmployeeRole());
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Generating Payslip for all Employees...");
                    List<Employee> allEmployees = organisation.getAllEmployees();
                    for (Employee employee : allEmployees) {
                        payroll.calculateAndPrintSalary(employee);
                    }

                default:
                    break;
            }

        } while (choice != 7);
        scanner.close();

    }
}
