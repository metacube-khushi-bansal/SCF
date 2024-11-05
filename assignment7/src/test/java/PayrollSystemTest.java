package test.java;

import Main.java.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.*;

public class PayrollSystemTest {
    private Organisation organisation;
    private Payroll payroll;

    @BeforeEach
    void setUp() {
        organisation = new Organisation("Metacube", null);
        payroll = new Payroll();
    }

    @Test
    void testOrganisation() {
        // creating the hr dept
        Department hrDept = new HRDept();
        // creating the it dept
        Department itDept = new ITDept();
        assertTrue(organisation.addDepartment(hrDept) == true);
        assertTrue(organisation.addDepartment(itDept) == true);

        // creating employees of hr type
        Employee hrEmployee1 = new HR("aditi", 1, "hr", "hr");
        Employee hrEmployee2 = new HR("sakshi", 2, "hr", "hr");

        assertTrue(hrDept.joinEmployee(hrEmployee1) == true);
        assertTrue(hrDept.joinEmployee(hrEmployee2) == true);

        Employee itEmployee1 = new Developer("khushi", 3, "it", "developer");
        Employee itEmployee2 = new Developer("Aman", 4, "it", "developer");

        assertTrue(itDept.joinEmployee(itEmployee1) == true);
        assertTrue(itDept.joinEmployee(itEmployee2) == true);

        // to check if 2 it employees added successfully to their respective dept
        assertEquals(2, itDept.getEmployees().size());

        // to check if 2 HR employees added successfully to their respective dept
        assertEquals(2, hrDept.getEmployees().size());

        // to check the number of all employees in the organisation
        assertEquals(4, organisation.getAllEmployees().size());

        // generate salaryslips for all employees
        List<Employee> employees = organisation.getAllEmployees();
        for (Employee employee : employees) {
            payroll.calculateAndPrintSalary(employee);
        }
    }

}
