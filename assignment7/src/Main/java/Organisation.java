package Main.java;

import java.util.ArrayList;
import java.util.List;

public class Organisation {
   private String name;
   List<Department> departments;

   public Organisation(String name, List<Department> departments) {
      this.name = name;
      this.departments = new ArrayList<>();
   }

   public String getNameOfOrganisation() {
      return name;
   }

   /**
    * To add a new department to the organisation
    * 
    * @param department- The department to be added
    * @return booolean - true- if dept successfully added otherwise false
    */
   public boolean addDepartment(Department department) {
      if (department.getDepartmentName().isEmpty()) {
         System.out.println("Department details are empty! Enter proper details");
         return false;
      }

      departments.add(department);
      // System.out.println("Department added successfully");

      return true;
   }

   /**
    * To get a dept by providing its name
    * 
    * @param deptName - The name of the dept
    * @return- the Departmentif found in the organisation
    */
   public Department getDepartmentByName(String deptName) {
      Department findDepartment = null;
      for (Department dept : departments) {
         if (dept.getDepartmentName().equalsIgnoreCase(deptName)) {
            findDepartment = dept;
            break;
         }
      }
      return findDepartment;
   }

   List<Department> getAllDepartments() {
      return departments;
   }

   /**
    * To get all the employees present in an organisation
    * 
    * @return List of Employees - Present in the organisation
    */

   public List<Employee> getAllEmployees() {
      List<Employee> employees = new ArrayList<>();
      for (Department dept : departments) {
         employees.addAll(dept.getEmployees());
      }
      return employees;
   }

}
