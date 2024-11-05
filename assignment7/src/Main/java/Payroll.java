package Main.java;

public class Payroll {

    /**
     * To calculate & print the Total salary of an employee after tax deductions
     * 
     * @param employee- Employee whose salary slip has to be printed
     */
    public void calculateAndPrintSalary(Employee employee) {
        double totalSalary = employee.getTotalSalary();
        double payableTax = calculateTax(totalSalary);

        System.out.println("Payslip for employee: \n" + employee.getEmployeeName() + " ID: " + employee.getEmployeeId()
                + " Dept: " + employee.getEmployeeDeptName() + " Role: " + employee.getEmployeeRole());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Bonus: " + employee.getBonus());
        System.out.println("Compensation : " + employee.getCompensation());
        System.out.println("Gross Salary: " + totalSalary);
        System.out.println("Payable Tax: " + payableTax);
        System.out.println("Net Salary: " + (totalSalary - payableTax));
    }

    /**
     * To calculate tax on the Total Salary of an employee
     * 
     * @param totalSalary - Total salary of the employee
     * @return double- Tax which is to be deducted from the salary
     */
    public double calculateTax(double totalSalary) {
        double tax;
        if (totalSalary < 50000)
            tax = totalSalary * 0.05;
        else if (totalSalary < 100000)
            tax = totalSalary * 0.10;
        else
            tax = totalSalary * 0.15;

        return tax;
    }
}
