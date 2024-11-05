package Main.java;

public class Developer extends Employee {

    public Developer(String name, int id, String deptName, String role) {
        super(name,id,deptName,role);
    }
    @Override
    public double getBasicSalary() {
    return 45000;   
    }

    @Override
    public double getBonus() {
      return 6000;
    }

    @Override
    public double getCompensation() {
       return 3000;
    }

}
